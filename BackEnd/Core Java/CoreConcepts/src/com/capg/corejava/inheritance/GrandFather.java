package com.capg.corejava.inheritance;

public class GrandFather {

	String name = "Torrhen";
	String lastname = "Stark";
	public static void main(String[] args) {
		
		GrandFather g = new GrandFather();
		g.printName();
	}
	
	public void printName() {
		System.out.println(name+" "+lastname);
	}
}
