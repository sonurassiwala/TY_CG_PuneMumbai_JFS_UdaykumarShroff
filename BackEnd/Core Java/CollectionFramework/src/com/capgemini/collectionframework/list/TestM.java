package com.capgemini.collectionframework.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestM {

	public static void main(String[] args) {

	LinkedList<String> str = new LinkedList<String>();
	str.add("Amya");
	str.add("Surya");
	str.add("Rushi");
	
	System.out.println("**********for*******************");
	for (int i = 0; i < 3; i++) {
		String r = str.get(i);
		System.out.println(r);
	}
	
	System.out.println("**********for-each*******************");
	for(String o : str) {
		System.out.println(o);
	}
	
	System.out.println("**********iterator*******************");
	Iterator<String> it = str.iterator();
	while(it.hasNext()) {
		String r = it.next();
		System.out.println(r);
	}
	
	System.out.println("**********ListIterator*******************");
	System.out.println("**********Forward*******************");
	ListIterator<String> lit = str.listIterator();
	while(lit.hasNext()) {
		String t = lit.next();
		System.out.println(t);
	}
	System.out.println("**********Backward*******************");
	while(lit.hasPrevious()) {
		String y = lit.previous();
		System.out.println(y);
	}
		
	}

}
