package com.capgemini.sorting.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TestE {

	public static void main(String[] args) {

		TreeSet t = new TreeSet();
		
		t.add(15);
		t.add(12);
		t.add(3);
		t.add(null);	//nullpointerexception - can't accept null
		
		System.out.println("***for-each***");
		for(Object r : t) {
			System.out.println(r);
		}
		System.out.println("***Iterator***");
		Iterator it = t.iterator();
		while(it.hasNext()) {
			Object r = it.next();
			System.out.println(r);
		}
		
	}

}
