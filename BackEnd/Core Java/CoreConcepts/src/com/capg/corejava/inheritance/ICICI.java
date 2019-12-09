package com.capg.corejava.inheritance;

public class ICICI implements ATM{

	@Override
	public void validatecard() {
		System.out.println("***Connecting ICICI***");
		System.out.println("Validating ICICI card");		
	}

	@Override
	public void getInfo() {
		System.out.println("***Connecting HDFC***");
		System.out.println("Getting Info of HDFC card");		
	}

}
