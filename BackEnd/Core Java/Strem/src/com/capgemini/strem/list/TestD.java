package com.capgemini.strem.list;

import java.util.ArrayList;
import java.util.Comparator;

public class TestD {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(5);
		al.add(10);
		al.add(6);
		al.add(3);
		al.add(4);
		
		Comparator<Integer> c = (i,j) -> i.compareTo(j);
		
		Integer small = al.stream().min(c).get();
		System.out.println("Smallest : "+small);
		
		Integer large = al.stream().max(c).get();
		System.out.println("Largest : "+large);
		
	}

}
