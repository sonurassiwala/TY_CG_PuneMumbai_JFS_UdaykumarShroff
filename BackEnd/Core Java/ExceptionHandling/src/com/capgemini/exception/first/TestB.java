package com.capgemini.exception.first;

public class TestB {

	public static void main(String[] args) {

		System.out.println("Main Started");
		
		try {
		System.out.println("Hi");
		System.out.println(10/0);
		System.out.println("Keep Smiling");
		System.out.println(4/0);
		}
		catch(ArithmeticException e) {
			System.out.println("Divide by zero");
		}
		
		System.out.println("Main Ended");
		
	}

}
