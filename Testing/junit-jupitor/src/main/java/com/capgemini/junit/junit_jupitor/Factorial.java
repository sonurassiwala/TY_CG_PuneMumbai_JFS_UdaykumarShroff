package com.capgemini.junit.junit_jupitor;

public class Factorial {

	public int fact(int a) {
		int k = 1;
		for( int i=1; i<=a; i++) {
			k= k*i;
		}
		return k;
	}
	
}
