package com.capgemini.array.genric;

public class RecDouble {

	public static void main(String[] args) {

		double d[] = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		receive(d);
		
	}

	static void receive(double p[]) {
		
		for(double r : p) {
			System.out.print(" "+r);
		}
		
	}
}
