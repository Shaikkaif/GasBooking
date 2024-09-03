package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class GasBooking {
	
	public GasBooking() {
		super();
	}

	public GasBooking(long gasBookingId, LocalDate bookingDate, boolean status, float bill, User user) {
		super();
		this.gasBookingId = gasBookingId;
		this.bookingDate = bookingDate;
		this.status = status;
		this.bill = bill;
		this.user = user;
	}

	@Id
	private long gasBookingId;
	private LocalDate bookingDate;
	private boolean status;
	private float bill;
	
	@ManyToOne
	@JsonBackReference
	private User user;

	public long getGasBookingId() {
		return gasBookingId;
	}

	public void setGasBookingId(long gasBookingId) {
		this.gasBookingId = gasBookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

