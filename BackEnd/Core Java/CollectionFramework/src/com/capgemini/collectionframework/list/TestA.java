package com.capgemini.collectionframework.list;

import java.util.ArrayList;

public class TestA {

	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		al.add(24);
		al.add("Chinuu");
		al.add(2.9);
		al.add('F');
		
		
		for (int j = 0; j <4 ; j++) {
			Object r = al.get(j);
			System.out.println(r);
		}
		
		
	}

}
