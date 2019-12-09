package com.capgemini.collectionframework.display;

import java.util.ArrayList;

public class TestS {

	public static void main(String[] args) {

		ArrayList<Double> al = new ArrayList<Double>();
		
		al.add(3.6);
		al.add(2.4);
		al.add(4.7);
		al.add(1.6);	//add method add the data into last index
		
		System.out.println(al);
		
		Double d = al.set(2, 7.8);
		System.out.println("Removed item is "+d);
		
		boolean b = al.remove(2.4);
		System.out.println("Result is "+b);
		
		al.add(5.4);
		Double res = al.remove(2);
		System.out.println("Removed : "+res);
		
		System.out.println(al);
		
		boolean v = al.isEmpty();
		System.out.println("Result is"+v);
		
		al.clear();
		System.out.println(al);
		
		boolean v1 = al.isEmpty();
		System.out.println("Result is"+v1);
		
	}

}
