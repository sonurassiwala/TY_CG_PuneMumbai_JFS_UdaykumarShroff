package com.capgemini.collectionframework.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class TestO {

	public static void main(String[] args) {

		Vector<Character> c = new Vector<Character>();
		c.add('A');
		c.add('P');
		c.add('P');
		c.add('L');
		c.add('E');
		
		System.out.println("**********for*******************");
		for (int i = 0; i < 5; i++) {
			Character r = c.get(i);
			System.out.println(r);
		}
		
		System.out.println("**********for-each*******************");
		for(Character o : c) {
			System.out.println(o);
		}
		
		System.out.println("**********iterator*******************");
		Iterator<Character> it = c.iterator();
		while(it.hasNext()) {
			Character r = it.next();
			System.out.println(r);
		}
		
		System.out.println("**********ListIterator*******************");
		System.out.println("**********Forward*******************");
		ListIterator<Character> lit = c.listIterator();
		while(lit.hasNext()) {
			Character t = lit.next();
			System.out.println(t);
		}
		System.out.println("**********Backward*******************");
		while(lit.hasPrevious()) {
			Character y = lit.previous();
			System.out.println(y);
		}
	}

}
