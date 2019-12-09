package com.capgemini.exception.first;

public class Paytm {

	void book() {
		
		System.out.println("Book Started");
		
		IRCTC i = new IRCTC();
		
		try {
			i.confirm();
		}
		catch(ArithmeticException a) {
			System.out.println("Exception caught by book");	
		}
		
		System.out.println("Book Ended");
	}
	
}
