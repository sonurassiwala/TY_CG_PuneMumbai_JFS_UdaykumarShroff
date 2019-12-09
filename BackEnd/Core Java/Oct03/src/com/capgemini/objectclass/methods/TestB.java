package com.capgemini.objectclass.methods;

public class TestB {

	public static void main(String[] args) {

		Pen p = new Pen();
		 int add = p.hashCode();
		 System.out.println("Address is : "+add);
		 
		 String r = p.toString();	// return fully qualified path name along with hexadecimal code of hashcode
		 System.out.println(r);
		 System.out.println(p); 	// reference variable will return the fully qualified path name with address it is same as toString() method
	}

}
