package com.capgemini.exception.first;

public class TestH {

	public static void main(String[] args) {

		System.out.println("Main started");
		
		String s = null;
		int[] a = new int[3];
		
		
		try {
		System.out.println(10/2);
		System.out.println(a[1]);
		System.out.println(s.length());
		}
		catch(ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("Main ended");
		
	}

}
