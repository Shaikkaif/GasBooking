package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bank;
import com.example.demo.entity.GasBooking;
import com.example.demo.entity.SurrenderCylinder;
import com.example.demo.exception.BankCodeException;
import com.example.demo.exception.BookingIdException;
import com.example.demo.exception.CustomerIdException;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addBooking")
	public ResponseEntity<GasBooking> addBooking(@RequestBody GasBooking gasBooking,@RequestParam long userId) throws BookingIdException{
		GasBooking addBooking=userService.addBooking(gasBooking, userId);
		return new ResponseEntity<GasBooking>(addBooking,HttpStatus.CREATED); 
	}
	
	@PutMapping("/updateBooking")
	public ResponseEntity<GasBooking> updateBooking(@RequestBody GasBooking gasBooking,@RequestParam long gasBookingId) throws BookingIdException{
		GasBooking updateBooking=userService.updateBooking(gasBooking, gasBookingId);
		return new ResponseEntity<GasBooking>(updateBooking,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewBooking")
	public ResponseEntity<GasBooking> viewBooking(@RequestParam long gasBookingId) throws BookingIdException{
		GasBooking viewBooking=userService.viewBooking(gasBookingId);
		return new ResponseEntity<GasBooking>(viewBooking,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/cancelBooking")
	public ResponseEntity<String> cancelBooking(@RequestParam long gasBookingId) throws BookingIdException{
		String cancelBooking=userService.cancelBooking(gasBookingId);
		return new ResponseEntity<String>(cancelBooking,HttpStatus.OK);
	}
	
	@GetMapping("/bookingDetails")
	public ResponseEntity<GasBooking> bookingDetails(@RequestParam long gasBookingId) throws BookingIdException{
		GasBooking bookingDetails=userService.bookingDetails(gasBookingId);
		return new ResponseEntity<GasBooking>(bookingDetails,HttpStatus.FOUND);
	}
	
	@PostMapping("/addSurrCylinder")
	public ResponseEntity<SurrenderCylinder> addSurrCylinder(@RequestBody SurrenderCylinder surrenderCylinder,@RequestParam long userId) throws CustomerIdException{
		SurrenderCylinder addSurrCylinder=userService.addSurrCylinder(surrenderCylinder, userId);
		return new ResponseEntity<SurrenderCylinder>(addSurrCylinder,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateSurrCylinder")
	public ResponseEntity<SurrenderCylinder> updateSurrCylinder(@RequestBody SurrenderCylinder surrenderCylinder,@RequestParam long surrenderId) throws CustomerIdException{
		SurrenderCylinder updateSurrCylinder=userService.updateSurrCylinder(surrenderId, surrenderCylinder);
		return new ResponseEntity<SurrenderCylinder>(updateSurrCylinder,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewSurrCylinder")
	public ResponseEntity<SurrenderCylinder> viewSurrCylinder(@RequestParam long surrenderId) throws CustomerIdException{
		SurrenderCylinder viewSurrCylinder=userService.viewSurrCylinder(surrenderId);
		return new ResponseEntity<SurrenderCylinder>(viewSurrCylinder,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/removeSurrcylinder")
	public ResponseEntity<String> removeSurrcylinder(@RequestParam long surrenderId) throws CustomerIdException{
		String removeSurrcylinder=userService.removeSurrcylinder(surrenderId);
		return new ResponseEntity<String>(removeSurrcylinder,HttpStatus.OK);
	}
	
	@PutMapping("/updateBank")
	public ResponseEntity<Bank> updateBank(@RequestBody Bank bank,@RequestParam long bankId) throws BankCodeException{
		Bank updateBank=userService.updateBank(bankId, bank);
		return new ResponseEntity<Bank>(updateBank,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewBank")
	public ResponseEntity<Bank> viewBank(@RequestParam long bankId) throws BankCodeException{
		Bank viewBank=userService.viewBank(bankId);
		return new ResponseEntity<Bank>(viewBank,HttpStatus.FOUND);
	}
	

}
