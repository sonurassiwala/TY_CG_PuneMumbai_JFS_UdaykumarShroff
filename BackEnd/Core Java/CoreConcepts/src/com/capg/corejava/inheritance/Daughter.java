package com.capg.corejava.inheritance;

public class Daughter extends Father implements InterfaceExample {
		
	String dname = "Sansa";
	
	public static void main(String[] args) {
	
		Daughter daughter = new Daughter();
		daughter.printName();
		daughter.display();
		daughter.show();
		
	}
	
	@Override
	public void printName() {
		System.out.println(dname+" "+fname+" "+lastname);
	}

	@Override
	public void display() {
		System.out.println("Display method in Daughter");		
	}

	@Override
	public void show() {
		System.out.println("Show method in Daughter");
	}

}
