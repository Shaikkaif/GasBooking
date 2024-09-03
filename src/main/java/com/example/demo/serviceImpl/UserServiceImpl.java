package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bank;
import com.example.demo.entity.GasBooking;
import com.example.demo.entity.SurrenderCylinder;
import com.example.demo.entity.User;
import com.example.demo.exception.BankCodeException;
import com.example.demo.exception.BookingIdException;
import com.example.demo.exception.CustomerIdException;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.GasBookingRepository;
import com.example.demo.repository.SurrenderCylinderRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private GasBookingRepository gasBookingRepository;
	
	@Autowired
	private SurrenderCylinderRepository surrenderCylinderRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public GasBooking addBooking(GasBooking gasBooking,long userId) throws BookingIdException {
		User user2=userRepository.findById(userId).orElseThrow(()->new BookingIdException("Booking Not Found..."));
		gasBooking.setUser(user2);
		GasBooking gasBooking2= gasBookingRepository.save(gasBooking);
		return gasBooking2;
	}

	@Override
	public GasBooking updateBooking(GasBooking gasBooking, long gasBookingId) throws BookingIdException {
		GasBooking gasBooking2=gasBookingRepository.findById(gasBookingId).orElseThrow(()->new BookingIdException("Booking Not Found..."));
		gasBooking2.setBookingDate(gasBooking.getBookingDate());
		return gasBookingRepository.save(gasBooking2);
	}

	@Override
	public GasBooking viewBooking(long gasBookingId) throws BookingIdException {
		GasBooking gasBooking2=gasBookingRepository.findById(gasBookingId).orElseThrow(()->new BookingIdException("Booking Not Found..."));
		return gasBooking2;
	}

	@Override
	public String cancelBooking(long gasBookingId) throws BookingIdException {
		GasBooking gasBooking2=gasBookingRepository.findById(gasBookingId).orElseThrow(()->new BookingIdException("Booking Not Found..."));
		gasBookingRepository.delete(gasBooking2);
		return "Cancelled Successfull...!";
	}

	@Override
	public GasBooking bookingDetails(long gasBookingId) throws BookingIdException {
		GasBooking gasBooking2=gasBookingRepository.findById(gasBookingId).orElseThrow(()->new BookingIdException("Booking Not Found..."));
		return gasBooking2;
	}

	@Override
	public SurrenderCylinder addSurrCylinder(SurrenderCylinder surrenderCylinder,long  userId) throws CustomerIdException {
		User user2=userRepository.findById(userId).orElseThrow(()-> new CustomerIdException("No Surrender Cylinder Found.."));
		surrenderCylinder.setUser(user2);
		SurrenderCylinder surrCylinder= surrenderCylinderRepository.save(surrenderCylinder);
		return surrCylinder;
	}

	@Override
	public SurrenderCylinder updateSurrCylinder(long surrenderId, SurrenderCylinder surrenderCylinder) throws CustomerIdException {
		SurrenderCylinder surrCylinder= surrenderCylinderRepository.findById(surrenderId).orElseThrow(()-> new CustomerIdException("No Surrender Cylinder Found.."));
		surrCylinder.setSurrenderDate(surrenderCylinder.getSurrenderDate());
		return surrenderCylinderRepository.save(surrCylinder);
	}

	@Override
	public SurrenderCylinder viewSurrCylinder(long surrenderId) throws CustomerIdException {
		SurrenderCylinder surrCylinder= surrenderCylinderRepository.findById(surrenderId).orElseThrow(()-> new CustomerIdException("No Surrender Cylinder Found.."));
		return surrCylinder;
	}

	@Override
	public String removeSurrcylinder(long surrenderId) throws CustomerIdException {
		SurrenderCylinder surrCylinder= surrenderCylinderRepository.findById(surrenderId).orElseThrow(()-> new CustomerIdException("No Surrender Cylinder Found.."));
		surrenderCylinderRepository.delete(surrCylinder);
		return "Cylinder removed Successfull..";
	}

	@Override
	public Bank updateBank(long bankId,Bank bank) throws BankCodeException {
		Bank bank2= bankRepository.findById(bankId).orElseThrow(()-> new BankCodeException("Bank Id Not Found"));
	  	bank2.setBankAddress(bank.getBankAddress());
	  	bank2.setBankName(bank.getBankName());
		return bankRepository.save(bank2);
	}

	@Override
	public Bank viewBank(long bankId) throws BankCodeException {
		Bank bank2= bankRepository.findById(bankId).orElseThrow(()-> new BankCodeException("Bank Id Not Found"));
		return bank2; 
	} 

}
