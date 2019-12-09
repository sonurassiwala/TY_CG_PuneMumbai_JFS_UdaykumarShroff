package com.capg.corejava.methods;

public class MethodsExample {

	int y = 10;
	public static void main(String[] args) {
		print();
		int i = areaOfSquare(5);
		System.out.println(i);
		//areaOfSquare(5);
		/*
		 * int i = areaOfSquare(5);
		 * System.out.println(i);
		 * or
		 * System.out.println("Area of Square : "+areaOfSquare(5));
		 */
		// int area = new MethodsExample().areaOfRect(5, 7);
		// System.out.println(area);
		System.out.println(new MethodsExample().areaOfRect(5, 7));

	}
	public static void print()
	{
		System.out.println("print() method");
	}
	public static int areaOfSquare(int side) {
		
		 // int area = side*side; 
		  //System.out.println("Area is  : "+area); 
		  return side*side;
	}
	public static int areaOfRect(int length, int breadth) {
		return length*breadth;
	}
}
