package com.capgemini.newstudent;

import java.util.function.Function;

public class TestB {

	public static void main(String[] args) {

		Function<Integer, Integer> f = i -> i*i;
		
		int ans = f.apply(5);
		System.out.println("Answer is : "+ans);
		
		
	}

}
