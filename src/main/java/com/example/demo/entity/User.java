package com.example.demo.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(Bank bank, Cylinder cylinder, long accNo, long userId, String userName, String userAddress, long phNo,
			String email, String password, List<GasBooking> gasBooking,Set<Role> role ) {
		super();
		this.bank = bank;
		this.cylinder = cylinder;
		this.accNo = accNo;
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.phNo = phNo;
		this.email = email;
		this.password = password;
		this.gasBooking = gasBooking;
		this.role=role;
	}

	@OneToOne
	private Bank bank;
	
	@OneToOne
	private Cylinder cylinder;
	
	private long accNo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String userName;
	private String userAddress;
	private long phNo;
	private String email;
	private String password;
	
	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY,mappedBy = "user")
	@JsonManagedReference
	private List<GasBooking> gasBooking;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="User_Roles", joinColumns = {@JoinColumn(name="User_Id")}, inverseJoinColumns = {@JoinColumn(name="Role_Name")})
	private Set<Role> role;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Cylinder getCylinder() {
		return cylinder;
	}

	public void setCylinder(Cylinder cylinder) {
		this.cylinder = cylinder;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<GasBooking> getGasBooking() {
		return gasBooking;
	}

	public void setGasBooking(List<GasBooking> gasBooking) {
		this.gasBooking = gasBooking;
	}
	
	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authorities=new HashSet<Authority>();
		this.role.forEach(userRole->{
			authorities.add(new Authority("Role"+userRole.getRole()));
		}
		);
		return authorities;
	} 

	@Override
	public String getUsername() {
		return this.email;
	}

	

}
