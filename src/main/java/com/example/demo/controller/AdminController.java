package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cylinder;
import com.example.demo.entity.GasBooking;
import com.example.demo.entity.User;
import com.example.demo.exception.BankCodeException;
import com.example.demo.exception.CustomerIdException;
import com.example.demo.exception.CylinderIdException;
import com.example.demo.exception.InvalidAdminException;
import com.example.demo.service.AdminService;

import jakarta.annotation.PostConstruct;

@RestController
public class AdminController { 
	
	@Autowired
	private AdminService adminService;
	
	@PostConstruct
	public void addRoles() {
		adminService.addRoles();
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<User> addAdmin(@RequestBody User admin){
		User addAdmin=adminService.addAdmin(admin);
		return new ResponseEntity<>(addAdmin,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateAdmin")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<User> updateAdmin(@RequestParam long adminId,@RequestBody User admin) throws InvalidAdminException{
		User updateAdmin=adminService.updateAdmin(admin, adminId);
		return new ResponseEntity<User>(updateAdmin,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewAdmin")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<User> viewAdmin(@RequestParam long adminId) throws InvalidAdminException{
		User viewAdmin=adminService.viewAdmin(adminId);
		return new ResponseEntity<User>(viewAdmin,HttpStatus.FOUND);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User addcustomer=adminService.addUser(user);
		return new ResponseEntity<>(addcustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateUser")
	@PreAuthorize("hasRole('Customer')")
	public ResponseEntity<User> updateUser(@RequestParam long userId,@RequestBody User user) throws CustomerIdException{
		User updateCutomer=adminService.updateUser(user, userId);
		return new ResponseEntity<User>(updateCutomer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewUser")
	@PreAuthorize("hasRole('Customer')")
	public ResponseEntity<User> viewUser(@RequestParam long userId) throws CustomerIdException{
		User viewCustomer=adminService.viewUser(userId);
		return new ResponseEntity<User>(viewCustomer,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam long userId) throws CustomerIdException{
		String deleteCustomer=adminService.deleteUser(userId);
		return new ResponseEntity<String>(deleteCustomer,HttpStatus.OK);
	}
	
	@PutMapping("/updateCylinder")
	public ResponseEntity<Cylinder> updateCylinder(@RequestParam long cylinderId, @RequestBody Cylinder cylinder) throws CylinderIdException{
		Cylinder updateCylinder=adminService.updateCylinder(cylinderId, cylinder);
		return new ResponseEntity<Cylinder>(updateCylinder,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewCylinder")
	public ResponseEntity<Cylinder> viewCylinder(@RequestParam long cylinderId) throws CylinderIdException{
		Cylinder viewCylinder=adminService.viewCylinder(cylinderId);
		return new ResponseEntity<Cylinder>(viewCylinder,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/removeCylinder")
	public ResponseEntity<String> removeCylinder(@RequestParam long cylinderId) throws CylinderIdException{
		String removeCylinder=adminService.removeCylinder(cylinderId);
		return new ResponseEntity<String>(removeCylinder,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBank")
	public ResponseEntity<String> deleteBank(@RequestParam long bankId) throws BankCodeException{
		String deleteBank=adminService.deleteBank(bankId);
		return new ResponseEntity<String>(deleteBank,HttpStatus.OK);
	}
	
	@GetMapping("/listOfBooking")
	public ResponseEntity<List<GasBooking>> listOfBooking(@RequestParam LocalDate d1, @RequestParam LocalDate d2){
		List<GasBooking> listOfBooking=adminService.listOfBooking(d1, d2);
		return new ResponseEntity<>(listOfBooking,HttpStatus.FOUND);
	}
	
	@GetMapping("/bookingDetails1")
	public ResponseEntity<GasBooking> bookingDetails1(@RequestParam long userId){
		GasBooking bookingDetails=adminService.bookingDetails1(userId);
		return new ResponseEntity<GasBooking>(bookingDetails,HttpStatus.FOUND);
	}

	@GetMapping("/monthlyRevenue")
	public ResponseEntity<Double> monthlyRevenue(@RequestParam LocalDate date1, @RequestParam LocalDate date2) throws Exception{
		double monthlyRevenue=adminService.monthlyRevenue(date1, date2);
		return new ResponseEntity<>(monthlyRevenue,HttpStatus.FOUND);
	}
}
