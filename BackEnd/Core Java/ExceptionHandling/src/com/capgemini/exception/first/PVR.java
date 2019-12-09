package com.capgemini.exception.first;

public class PVR {

	void confirm() {
		
		System.out.println("confirm started");
		
		try {
		System.out.println(10/5);
		}
		catch(ArithmeticException e) {
			System.out.println("Exception caught by confirm");
			throw e;
		}
		finally {		//always it will execute weather there is exception or not
		System.out.println("confirm ended");
		}
	}
	
	
}
