package com.capg.corejava.inheritance;

public class Testb {

	public static void main(String[] args) {
		
		Machine m = new Machine();
		HDFC h = new HDFC();
		ICICI i =new ICICI();
		
		m.slot(h);
		m.slot(i);
		
	}

}

