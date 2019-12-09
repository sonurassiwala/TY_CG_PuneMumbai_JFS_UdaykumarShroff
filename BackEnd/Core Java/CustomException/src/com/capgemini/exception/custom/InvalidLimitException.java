package com.capgemini.exception.custom;

public class InvalidLimitException extends Exception
{

	private String msg = "Limit Exceeds";
	
	
	
	public InvalidLimitException(String msg) {
		this.msg = msg;
	}
	
	public InvalidLimitException() {
	}

	@Override
	public String getMessage() {
		return msg;
	}
	
}
