package com.capgemini.collectionframework.display;

import java.util.ArrayList;

public class TestT {

	public static void main(String[] args) {

		ArrayList<Double> al = new ArrayList<Double>();
		
		al.add(3.6);
		al.add(2.4);
		al.add(4.7);
		al.add(1.6);
		
		System.out.println("***Before***");
		System.out.println(al);
		
		ArrayList<Double> bl = new ArrayList<Double>();
		bl.add(29.4);
		bl.add(16.2);
		
		al.addAll(bl);
		System.out.println("***After***");
		System.out.println(al);
		
		
		System.out.println("**Removing**");
		
		al.removeAll(bl);
		System.out.println(al);
		
	}

}
