package com.capgemini.sorting.set;

import java.util.LinkedHashSet;
import java.util.Iterator;

public class TestD {

	public static void main(String[] args) {

		
		LinkedHashSet<Double> hs = new LinkedHashSet<Double>();
		
		hs.add(2.34);
		hs.add(1.89);
		hs.add(4.56);
		hs.add(3.21);
		
		System.out.println("***For-Each***");
		for(Double r : hs) {
			System.out.println(r);
		}
		
		System.out.println("*****Iterator*****");
		Iterator<Double> it = hs.iterator();
		while(it.hasNext()) {
			Double r = it.next();
			System.out.println(r);
		}
		
	}

}
