package com.capgemini.exception.first;

public class TestC {

	public static void main(String[] args) {

		System.out.println("Main Started");
		
		int[] a = new int[4];
		String s = null;
		
		try {							//a try block can have multiple catch block
			System.out.println(s.toUpperCase());
			System.out.println(a[6]);
			System.out.println(10/0);
		}
		
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exceeds Array Boundary");
		}
		catch(ArithmeticException r) {
			System.out.println("Don't Divide by Zero");
		}
		catch(NullPointerException n) {
			System.out.println("There is nothing");
		}
		catch(Exception f) {			//General Catch block is always at last
			System.out.println("Something went wrong");
		}
		
		
		System.out.println("Main Ended");
		
	}

}
