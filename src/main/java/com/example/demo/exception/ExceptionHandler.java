package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandler {

	public ResponseEntity<?> handleBookingIdException(BookingIdException bookingIdException,WebRequest webRequest){
		ErrorDetails errorDetails= new ErrorDetails(new Date(),bookingIdException.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> handleCustomerIdException(CustomerIdException customerIdException, WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(),customerIdException.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> handleBankCodeException(BankCodeException bankCodeException,WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(),bankCodeException.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_ACCEPTABLE);
	}
	
	public ResponseEntity<?> handleCylinderIdException(CylinderIdException cylinderIdException,WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(),cylinderIdException.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<?> handleInvalidAdminException(InvalidAdminException invalidAdminException,WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(),invalidAdminException.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_ACCEPTABLE);
	}
	
	public ResponseEntity<?> handleUserIdException(UserIdException userIdException,WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(),userIdException.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}

}
