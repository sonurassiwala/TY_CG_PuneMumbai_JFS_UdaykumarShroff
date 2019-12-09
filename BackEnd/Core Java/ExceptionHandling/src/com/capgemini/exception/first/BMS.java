package com.capgemini.exception.first;

public class BMS {

	public static void main(String[] args) {

		System.out.println("BMS started");
		
		PVR p = new PVR();
		
		try {
		p.confirm();
		}
		catch(ArithmeticException a) {
			System.out.println("Exception caught by BMS");
		}
		
		System.out.println("BMS Ended");
		
	}

}
