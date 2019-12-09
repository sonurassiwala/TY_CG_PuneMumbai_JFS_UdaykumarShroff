package com.capgemini.sorting.set;

import java.util.HashSet;
import java.util.Iterator;

public class TestA {

	public static void main(String[] args) {

		HashSet hs = new HashSet();
		
		hs.add(15);
		hs.add('A');
		hs.add(2.4);
		hs.add("Deepa");
		
		System.out.println("****For-Each*****");
		
		for(Object r : hs) {
			System.out.println(r);
		}
		
		System.out.println("*****Iterator*****");
		Iterator it = hs.iterator();
		while(it.hasNext()) {
			Object r = it.next();
			System.out.println(r);
		}
		
		
	}

}
