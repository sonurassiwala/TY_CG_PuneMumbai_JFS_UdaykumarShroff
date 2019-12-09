package com.capgemini.array.genric;

interface Square{
	
	int square(int a);
	
}

public class LambaSquare {

	public static void main(String[] args) {

		Square s = a-> a*a;
		int i = s.square(5);
		System.out.println("Square is : "+i);
		
	}

}
