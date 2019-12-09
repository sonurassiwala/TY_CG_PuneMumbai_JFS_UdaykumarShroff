package com.capgemini.collectionframework.list;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestK {

	public static void main(String[] args) {

		ArrayList<Double> dl = new ArrayList<Double>();
		dl.add(2.4);
		dl.add(3.2);
		dl.add(5.6);
		dl.add(12.23);
		
		ListIterator<Double> ld = dl.listIterator();
		while(ld.hasNext()) {
			Double d = ld.next();
			System.out.println(d);
		}
		
		System.out.println("***********");
		
		while(ld.hasPrevious()) {
			Double f = ld.previous();
			System.out.println(f);
		}
		
	}

}
