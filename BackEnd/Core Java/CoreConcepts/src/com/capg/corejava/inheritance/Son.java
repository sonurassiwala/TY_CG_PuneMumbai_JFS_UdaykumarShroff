package com.capg.corejava.inheritance;

public class Son extends Father implements InterfaceExample {

	String sname = "Robb";
	
	public static void main(String[] args) {
	
		Son son = new Son();
		son.printName();
		son.display();
		son.show();
		
	}
	
	@Override								
	public void printName() {
		System.out.println(sname+" "+fname+" "+lastname);
		super.printName();
	}

	@Override
	public void display() {
		System.out.println("Display method in Son");
	}

	@Override
	public void show() {
		System.out.println("Show method in Son");
	}

}
