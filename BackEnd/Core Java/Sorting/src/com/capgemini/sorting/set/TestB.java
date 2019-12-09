package com.capgemini.sorting.set;

import java.util.HashSet;
import java.util.Iterator;

public class TestB {

	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<String>();
		
		hs.add("Amya");
		hs.add("Surya");
		hs.add("Rushi");
		hs.add("Niru");
		
		System.out.println("***For-Each***");
		for(String r : hs) {
			System.out.println(r);
		}
		
		System.out.println("*****Iterator*****");
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			String r = it.next();
			System.out.println(r);
		}
		
	}

}
