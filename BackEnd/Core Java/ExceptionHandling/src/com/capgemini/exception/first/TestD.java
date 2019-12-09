package com.capgemini.exception.first;

public class TestD {

	public static void main(String[] args) {

		System.out.println("Main Started");
		
		int[] a = new int[4];
		String s = "suraj";
		
		try {							//a try block can have multiple catch block
			System.out.println(s.toUpperCase());
			System.out.println(a[2]);
			System.out.println(10/0);
		}
		catch(Exception e) {			//General catch block can catch any type of exception
			System.out.println("Exception has been occured");
		}
		
		
		System.out.println("Main Ended");
		
	}
	
}
