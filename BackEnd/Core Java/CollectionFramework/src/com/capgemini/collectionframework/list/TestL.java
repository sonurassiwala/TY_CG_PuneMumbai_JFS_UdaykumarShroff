package com.capgemini.collectionframework.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestL {

	public static void main(String[] args) {
		
		LinkedList li = new LinkedList();
		li.add(12);
		li.add("ASDF");
		li.add(2.3);
		
		System.out.println("**********for*******************");
		for (int i = 0; i < 3; i++) {
			Object r = li.get(i);
			System.out.println(r);
		}
		
		System.out.println("**********for-each*******************");
		for(Object o : li) {
			System.out.println(o);
		}
		
		System.out.println("**********iterator*******************");
		Iterator it = li.iterator();
		while(it.hasNext()) {
			Object r = it.next();
			System.out.println(r);
		}
		
		System.out.println("**********ListIterator*******************");
		System.out.println("**********Forward*******************");
		ListIterator lit = li.listIterator();
		while(lit.hasNext()) {
			Object t = lit.next();
			System.out.println(t);
		}
		System.out.println("**********Backward*******************");
		while(lit.hasPrevious()) {
			Object y = lit.previous();
			System.out.println(y);
		}
		
	}

}