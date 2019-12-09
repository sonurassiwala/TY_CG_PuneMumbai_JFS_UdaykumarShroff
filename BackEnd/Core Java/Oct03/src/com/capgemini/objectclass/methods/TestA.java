package com.capgemini.objectclass.methods;

public class TestA {

	public static void main(String[] args) {

		Pen p = new Pen();
		int add = p.hashCode();		//return the memory location where the object is created
		System.out.println("Address is : "+add);
		
		Pen s = new Pen();
		int add2 = s.hashCode();
		System.out.println("Address2 is : "+add2);
		
	}

}
