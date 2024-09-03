package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class SurrenderCylinder {

	public SurrenderCylinder() {
		super();
	}

	public SurrenderCylinder(long surrenderId, LocalDate surrenderDate, User user) {
		super();
		this.surrenderId = surrenderId;
		this.surrenderDate = surrenderDate;
		this.user = user;
	}

	@Id
	private long surrenderId;
	private LocalDate surrenderDate;
	
	@OneToOne
	private User user;

	public long getSurrenderId() {
		return surrenderId;
	}

	public void setSurrenderId(long surrenderId) {
		this.surrenderId = surrenderId;
	}

	public LocalDate getSurrenderDate() {
		return surrenderDate;
	}

	public void setSurrenderDate(LocalDate surrenderDate) {
		this.surrenderDate = surrenderDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}


