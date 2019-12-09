package com.capgemini.collectionframework.list;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestD {

	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		
		al.add(24);
		al.add("Chinuu");
		al.add(2.9);
		al.add('F');
		
		ListIterator m = al.listIterator();
		
		while(m.hasNext()) {
			Object c = m.next();
			System.out.println(c);
		}
		
		System.out.println("************");
		
		while(m.hasPrevious()) {
			Object e = m.previous();
			System.out.println(e);
		}
		
		
	}

}
