package com.capgemini.hotelmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.hotelmanagement.beans.HotelResponse;
import com.capgemini.hotelmanagement.exception.EmailAlreadyExistException;
import com.capgemini.hotelmanagement.exception.EmailNotExistException;
import com.capgemini.hotelmanagement.exception.HotelNotFoundException;
import com.capgemini.hotelmanagement.exception.IncorrectPasswordException;
import com.capgemini.hotelmanagement.exception.InvalidCredentialsException;
import com.capgemini.hotelmanagement.exception.NoBookingsAvailable;
import com.capgemini.hotelmanagement.exception.PasswordException;
import com.capgemini.hotelmanagement.exception.RoomNotFoundException;
import com.capgemini.hotelmanagement.exception.UnableToAddException;
import com.capgemini.hotelmanagement.exception.UnableToCalculateAmount;
import com.capgemini.hotelmanagement.exception.UserNotFoundException;

@RestControllerAdvice
public class HotelExceptionController {

	HotelResponse hotelResponse = new HotelResponse();
	
	@ExceptionHandler(HotelNotFoundException.class)
	public HotelResponse exception(HotelNotFoundException hotelNotFoundException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Hotel not found");
		return hotelResponse;
	}
	
	@ExceptionHandler(RoomNotFoundException.class)
	public HotelResponse exception(RoomNotFoundException roomNotFoundException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Room record not found");
		return hotelResponse;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public HotelResponse exception(UserNotFoundException roomNotFoundException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("User not found");
		return hotelResponse;
	}
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	public HotelResponse exception(EmailAlreadyExistException emailAlreadyExistException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Email already exist");
		return hotelResponse;
	}
	
	@ExceptionHandler(PasswordException.class)
	public HotelResponse exception(PasswordException passwordException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Minimum length of password should be 8. It should contain 1 uppercase, 1 lowercase, digits from 0-9, atleast one special character from '@#$%'");
		return hotelResponse;
	}
	
	@ExceptionHandler(IncorrectPasswordException.class)
	public HotelResponse exception(IncorrectPasswordException incorrectPasswordException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Entered Password Is Wrong");
		return hotelResponse;
	}
	
	@ExceptionHandler(UnableToAddException.class)
	public HotelResponse exception(UnableToAddException unableToAddException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Unable to add");
		return hotelResponse;
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public HotelResponse exception(InvalidCredentialsException invalidCredentialsException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Entered Credentials are wrong");
		return hotelResponse;
	}
	
	@ExceptionHandler(EmailNotExistException.class)
	public HotelResponse exception(EmailNotExistException emailNotExistException) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Entered Email Not Exists");
		return hotelResponse;
	}
	
	@ExceptionHandler(UnableToCalculateAmount.class)
	public HotelResponse exception(UnableToCalculateAmount unableToCalculateAmount) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("Unable To Calculate Total Amount........");
		return hotelResponse;
	}
	
	@ExceptionHandler(NoBookingsAvailable.class)
	public HotelResponse exception(NoBookingsAvailable noBookingsAvailable) {
		hotelResponse.setStatusCode(401);
		hotelResponse.setMessage("Failed");
		hotelResponse.setDescription("No Data Available........");
		return hotelResponse;
	}
	
}
