package com.capgemini.array.genric;

interface Fact{
	int fact(int a);
}

public class LambadaFact {

	public static void main(String[] args) {

		Fact d = k -> {
		int f = 1;
		for (int i = 1; i <= k; i++) {
			f = f*i;
		}
		return f;
		};
		int g = d.fact(5);
		System.out.println("Factorial is : "+g);
		
	}

}
