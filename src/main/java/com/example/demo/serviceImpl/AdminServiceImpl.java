package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bank;
import com.example.demo.entity.Cylinder;
import com.example.demo.entity.GasBooking;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.BankCodeException;
import com.example.demo.exception.CustomerIdException;
import com.example.demo.exception.CylinderIdException;
import com.example.demo.exception.InvalidAdminException;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.CylinderRepository;
import com.example.demo.repository.GasBookingRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CylinderRepository cylinderRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private GasBookingRepository gasBookingRepository;
	
	@Override
	public String addRoles() {
		Role adminRole =new Role();
		adminRole.setRole("Admin");
		roleRepository.save(adminRole);
		
		Role customerRole=new Role();
		customerRole.setRole("Customer");
		roleRepository.save(customerRole);
		
		return "Success";
	}
	
	@Override
	public User addAdmin(User admin) {
		Role role=roleRepository.findById("Admin").get();
		Set<Role> adminRole=new HashSet<Role>();
		adminRole.add(role);
		admin.setRole(adminRole);
		admin.setPassword(encoder.encode(admin.getPassword()));
		return userRepository.save(admin);
	}

	@Override
	public User updateAdmin(User admin, long adminId) throws InvalidAdminException {
		User admin2=userRepository.findById(adminId).orElseThrow(()-> new InvalidAdminException("Invalid Admin Details.."));
		admin2.setEmail(admin.getEmail());
		admin2.setPassword(encoder.encode(admin.getPassword()));;
		return userRepository.save(admin2);
	}

	@Override
	public User viewAdmin(long adminId) throws InvalidAdminException {
		User admin2=userRepository.findById(adminId).orElseThrow(()-> new InvalidAdminException("Invalid Admin Details.."));
		return admin2;
	}

	@Override
	public User addUser(User user) {
		Cylinder cylinder2= cylinderRepository.save(user.getCylinder());
		user.setCylinder(cylinder2);
		Bank bank2= bankRepository.save(user.getBank());
		user.setBank(bank2);
		
		Role role=roleRepository.findById("Customer").get();
		Set<Role> customerRole=new HashSet<Role>();
		customerRole.add(role);
		user.setRole(customerRole);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, long userId) throws CustomerIdException {
		User customer2= userRepository.findById(userId).orElseThrow(()-> new CustomerIdException("Customer Not Found.."));
		customer2.setPassword(encoder.encode(user.getPassword()));
		customer2.setEmail(user.getEmail());
		return userRepository.save(customer2);
	}
 
	@Override
	public User viewUser(long userId) throws CustomerIdException {
		User customer2= userRepository.findById(userId).orElseThrow(()-> new CustomerIdException("Customer Not Found.."));
		return customer2;
	}

	@Override
	public String deleteUser(long userId) throws CustomerIdException {
		User customer2= userRepository.findById(userId).orElseThrow(()-> new CustomerIdException("Customer Not Found.."));
		userRepository.delete(customer2);
		return "Customer Removed Successfully...!";
	}

	@Override
	public Cylinder updateCylinder(long cylinderId,Cylinder cylinder) throws CylinderIdException {
		Cylinder cylinder2=cylinderRepository.findById(cylinderId).orElseThrow(()-> new CylinderIdException("Cylinder Not Found.."));
		cylinder2.setCylinderPrice(cylinder.getCylinderPrice());
		cylinder2.setCylinderType(cylinder.getCylinderType());
		cylinder2.setCylinderWeight(cylinder.getCylinderWeight());
		return cylinderRepository.save(cylinder2);
	}

	@Override
	public Cylinder viewCylinder(long cylinderId) throws CylinderIdException {
		Cylinder cylinder2=cylinderRepository.findById(cylinderId).orElseThrow(()-> new CylinderIdException("Cylinder Not Found.."));
		return cylinder2;
	}

	@Override
	public String removeCylinder(long cylinderId) throws CylinderIdException {
		Cylinder cylinder2=cylinderRepository.findById(cylinderId).orElseThrow(()-> new CylinderIdException("Cylinder Not Found.."));
		cylinderRepository.delete(cylinder2);
		return "Cylinder Removed Successfully..!";
	}

	@Override
	public String deleteBank(long bankId) throws BankCodeException {
		Bank bank2= bankRepository.findById(bankId).orElseThrow(()-> new BankCodeException("Bank Id Not Found"));
		bankRepository.delete(bank2);
		return "Bank Removed Successfully..!";
	}

	@Override
	public List<GasBooking> listOfBooking(LocalDate d1, LocalDate d2) {
		List<GasBooking> listOfBooking= gasBookingRepository.findByBookingDate(d1,d2);
		return listOfBooking;
	}

	@Override
	public GasBooking bookingDetails1(long userId) {
		GasBooking bookingDetails=gasBookingRepository.findByUserUserId(userId);
		return bookingDetails;
	}

	@Override
	public double monthlyRevenue(LocalDate date1, LocalDate date2) throws Exception {
		if(date1==null || date2==null || date1.isAfter(date2)) {
			throw new Exception("Invalid");
		}
		
		List<GasBooking> gasBooking2=gasBookingRepository.findByBookingBetweenDates(date1,date2);
		double totalRevenue=0.0;
		for (GasBooking gasBooking : gasBooking2) {
			totalRevenue += gasBooking.getBill();
		} 
		return totalRevenue;
		}		

}
