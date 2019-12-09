package com.capgemini.sorting.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestC {

	public static void main(String[] args) {

		LinkedHashSet lh = new LinkedHashSet();
		
		lh.add(15);
		lh.add('A');
		lh.add(2.4);
		lh.add("Deepa");
		lh.add(null);
		lh.add(null);
		
		System.out.println("***for-each***");
		for(Object r : lh) {
			System.out.println(r);
		}
		
		System.out.println("*****Iterator*****");
		Iterator it = lh.iterator();
		while(it.hasNext()) {
			Object r = it.next();
			System.out.println(r);
		}
		
	}

}
