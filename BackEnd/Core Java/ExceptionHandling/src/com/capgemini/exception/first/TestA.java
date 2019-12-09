package com.capgemini.exception.first;

public class TestA {

	public static void main(String[] args) {

		System.out.println("Main Started");
		
		int[] a = new int[3];
		
		try {
		System.out.println(a[7]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Don't cross Array Index Boundary");
		}
		
		System.out.println("Main Ended");
		
	}

}
