package com.capg.corejava.interfaces;

public class InterfaceExampleImpl implements InterfaceExample1{

	@Override
	public void print() {
		System.out.println("Implemented print Method of Interface");
	}
	
	/*
	 * //@Override //override of static is not allowed in java8 public static void
	 * show() { System.out.println("Static Method of Interface"); }
	 */
	
	@Override  		//we can implement default method in implemented class
	public void display() {
		System.out.println("Implemented Display Method of Interface");
	}
	
	/*
	 * @Override public void printNum() { System.out.println("123456");
	 * 
	 * }
	 */
	
	public static void main(String[] args) {		//we cannot create the object of Interface
		InterfaceExample1 ie = new InterfaceExampleImpl();	//so we are giving object of impl class to refernce of interface
		ie.print();
		ie.display();
		//ie.printNum();
	}

	
	
	
}
