package com.capg.corejava.inheritance;

public class Lays implements Chips {

	@Override
	 public void open() {
		System.out.println("open lays");
	}
	 
	@Override 
	public void eat() {
		 System.out.println("Eat lays");
	 }
}
