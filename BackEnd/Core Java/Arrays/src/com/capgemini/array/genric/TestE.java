package com.capgemini.array.genric;

public class TestE {
	
	static void receive(int a[]) {
		
		for(int i : a) {
			System.out.print(" "+i);
		}
		
	}
	

	public static void main(String[] args) {
		
		int[] m = {1,2,3,4,5};
		receive(m);
		
	}

}
