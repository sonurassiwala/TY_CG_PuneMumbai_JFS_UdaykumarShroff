package com.capgemini.exception.first;

public class Test {

	public static void main(String[] args) {

		System.out.println("Main Started");
		
		Paytm p = new Paytm();
		try {
			p.book();
		}
		catch(ArithmeticException e) {
			System.out.println("Exception caught by main");
		}
		
		System.out.println("Main Ended");
	}

}
