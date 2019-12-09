package com.capgemini.exception.first;

public class Pen {

	public static void main(String[] args) {

		System.out.println("Main Started");
		
		try {
			System.out.println(10/0);		//if there is 0 then it make an exception  (of ArithmeticException) and throw to catch block
		}
		catch(ArithmeticException e) {
			System.out.println("Can't divide by Zero");
		}
		
		System.out.println("Main Ended");
		
	}

}
