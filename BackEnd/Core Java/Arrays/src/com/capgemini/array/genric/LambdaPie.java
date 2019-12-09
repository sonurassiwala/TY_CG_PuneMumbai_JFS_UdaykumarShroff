package com.capgemini.array.genric;

interface Pie{
	
	double pi();
	
}

public class LambdaPie {

	public static void main(String[] args) {
				
		Pie p = () -> 3.14;
		double t = p.pi();
		System.out.println("Value of Pie is : "+t);
		
	}

}
