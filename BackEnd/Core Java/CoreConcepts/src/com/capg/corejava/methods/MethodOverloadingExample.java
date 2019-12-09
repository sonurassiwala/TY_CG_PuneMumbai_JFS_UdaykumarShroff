package com.capg.corejava.methods;

public class MethodOverloadingExample {

	public static void main(String[] args) {
		
		System.out.println(add(5, 7));
		System.out.println(add(5, 8, 9));
		System.out.println(add(4, 54896.2316468, 45));
		System.out.println(add(78, 789.321, 45));
	}
	
	public static int add(int i, int j) {
		return i+j;
	}
	
	public static int add(int i, int j, int k) {
		return i+j+k;
	}
	
	public static double add(int i, int j, double d) {
		return i+j+d;
	}
	
	public static float add(int i,float f, int j) {
		return i+j+f;
	}

	public static double add(int i, double d, int j) {
		return i+j+d;
	}
}
