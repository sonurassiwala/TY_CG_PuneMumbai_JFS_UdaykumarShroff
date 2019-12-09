package com.capg.corejava.inheritance;

public class HDFC implements ATM {

	@Override
	public void validatecard() {
		System.out.println("***Connecting HDFC***");
		System.out.println("Validating HDFC card");
	}

	@Override
	public void getInfo() {
		System.out.println("***Connecting HDFC***");
		System.out.println("Getting Info of HDFC card");		
	}

}
