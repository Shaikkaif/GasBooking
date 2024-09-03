package com.example.demo.service;

import java.time.LocalDate;
//import java.util.List;
import java.util.List;

//import com.example.demo.entity.Bank;
import com.example.demo.entity.Cylinder;
import com.example.demo.entity.GasBooking;
import com.example.demo.entity.User;
//import com.example.demo.entity.GasBooking;
import com.example.demo.exception.BankCodeException;
import com.example.demo.exception.CustomerIdException;
import com.example.demo.exception.CylinderIdException;
//import com.example.demo.exception.InvalidAdminException;
import com.example.demo.exception.InvalidAdminException;

public interface AdminService {
	
	public String addRoles();
	
	public User addAdmin(User admin);
	public User updateAdmin(User admin, long adminId) throws InvalidAdminException;
	public User viewAdmin(long adminId) throws InvalidAdminException;
	
	public User addUser(User user);
	public User updateUser(User user,long userId) throws CustomerIdException; 
	public User viewUser(long userId) throws CustomerIdException;
	public String deleteUser(long userId) throws CustomerIdException;  
	
	public Cylinder updateCylinder(long cylinderId,Cylinder cylinder ) throws CylinderIdException;
	public Cylinder viewCylinder(long cylinderId) throws CylinderIdException;
	public String removeCylinder(long cylinderId) throws CylinderIdException;
	
	public String deleteBank(long bankId) throws BankCodeException;
	
	public List<GasBooking> listOfBooking (LocalDate d1, LocalDate d2);
	
	public GasBooking bookingDetails1(long userId);
	
	public double monthlyRevenue(LocalDate date1, LocalDate date2) throws Exception;

}

