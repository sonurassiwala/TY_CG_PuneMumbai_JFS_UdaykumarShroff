package com.capg.corejava.methods;

public class Demo {

	static MethodsExample me = new MethodsExample();

	public static void main(String[] args) {
		MethodsExample me1 = new MethodsExample();	//in main we cannot use static keyword
		System.out.println(me);
		System.out.println(me1);
		System.out.println("Area of Square : "+MethodsExample.areaOfSquare(5));
		System.out.println("Area of Rectangle : "+MethodsExample.areaOfRect(5, 7));
		System.out.println(me.areaOfRect(6, 7));
		System.out.println(me1.areaOfRect(6, 7));
		int r = me.y;
		System.out.println(r);
	}

}

