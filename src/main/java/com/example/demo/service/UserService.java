package com.example.demo.service;

import com.example.demo.entity.Bank;
import com.example.demo.entity.GasBooking;
import com.example.demo.entity.SurrenderCylinder;
import com.example.demo.exception.BankCodeException;
import com.example.demo.exception.BookingIdException;
import com.example.demo.exception.CustomerIdException;

public interface UserService { 
	
	public GasBooking addBooking(GasBooking gasBooking,long customerId) throws BookingIdException;
	public GasBooking updateBooking(GasBooking gasBooking, long gasBookingId) throws BookingIdException;
	public GasBooking viewBooking(long gasBookingId) throws BookingIdException;
	public String cancelBooking(long  gasBookingId) throws BookingIdException;
	
	public GasBooking bookingDetails(long  gasBookingId) throws BookingIdException;
	
	public SurrenderCylinder addSurrCylinder(SurrenderCylinder surrenderCylinder,long  customerId) throws CustomerIdException;
	public SurrenderCylinder updateSurrCylinder(long surrenderId, SurrenderCylinder surrenderCylinder) throws CustomerIdException;
	public SurrenderCylinder viewSurrCylinder(long surrenderId) throws CustomerIdException; 
	public String removeSurrcylinder(long surrenderId) throws CustomerIdException;
	
	public Bank updateBank(long bankId,Bank bank) throws BankCodeException;
	public Bank viewBank(long bankId) throws BankCodeException;
}
