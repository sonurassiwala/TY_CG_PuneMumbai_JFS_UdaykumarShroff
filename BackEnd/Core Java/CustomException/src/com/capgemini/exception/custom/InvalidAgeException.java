package com.capgemini.exception.custom;

public class InvalidAgeException extends RuntimeException	//custom unchecked exception
{	

	String msg = "Invalid Age to Proceed";
	
	public InvalidAgeException()
	{
		
	}

	public InvalidAgeException(String msg) {
		
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
	
}
