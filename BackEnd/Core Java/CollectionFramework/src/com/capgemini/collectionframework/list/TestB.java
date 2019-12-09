package com.capgemini.collectionframework.list;

import java.util.ArrayList;

public class TestB {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		
		al.add(24);
		al.add("Chinuu");
		al.add(2.9);
		al.add('F');
		
		for (Object r : al) {
			System.out.println(r);
		}
		
	}

}
