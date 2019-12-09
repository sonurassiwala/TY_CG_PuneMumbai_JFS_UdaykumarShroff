package com.capgemini.array.genric;

interface Sum{
	
	int add(int a, int b);
	
}

public class LambaExpression {

	public static void main(String[] args) {

		Sum f = (a,b) -> a+b;
		
		int j = f.add(20, 40);
		
		System.out.println("Sum is : "+j);
		
	}

}
