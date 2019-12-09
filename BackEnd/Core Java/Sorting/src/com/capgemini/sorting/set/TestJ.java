package com.capgemini.sorting.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TestJ {

	public static void main(String[] args) {

		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("Amit");
		ts.add("Suraj");
		ts.add("Rushi");
		ts.add("Niru");
		
		Iterator<String> it = ts.iterator();
		while(it.hasNext()) {
			String r = it.next();
			System.out.println(r);
		}
		
		
		
	}

}
