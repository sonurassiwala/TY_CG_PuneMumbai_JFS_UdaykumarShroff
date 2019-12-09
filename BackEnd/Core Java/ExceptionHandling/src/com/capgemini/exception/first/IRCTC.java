package com.capgemini.exception.first;

public class IRCTC {

	void confirm() {
		
		System.out.println("Confirm Started");
		
		try {
			System.out.println(10/0);
		}
		catch(ArithmeticException r) {
			System.out.println("Exception caught by confirm");
		}
		
		System.out.println("Confirm Ended");
	}
	
}
