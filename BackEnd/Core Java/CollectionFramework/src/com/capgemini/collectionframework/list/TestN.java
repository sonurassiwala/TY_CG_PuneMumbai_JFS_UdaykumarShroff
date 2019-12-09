package com.capgemini.collectionframework.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class TestN {

	public static void main(String[] args) {

		Vector v = new Vector();
		v.add(9.6);
		v.add('M');
		v.add("ASDF");
		
		System.out.println("**********for*******************");
		for (int i = 0; i < 3; i++) {
			Object r = v.get(i);
			System.out.println(r);
		}
		
		System.out.println("**********for-each*******************");
		for(Object o : v) {
			System.out.println(o);
		}
		
		System.out.println("**********iterator*******************");
		Iterator it = v.iterator();
		while(it.hasNext()) {
			Object r = it.next();
			System.out.println(r);
		}
		
		System.out.println("**********ListIterator*******************");
		System.out.println("**********Forward*******************");
		ListIterator lit = v.listIterator();
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
