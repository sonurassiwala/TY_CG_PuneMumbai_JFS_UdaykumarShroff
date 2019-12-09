package com.capgemini.collectionframework.list;

import java.util.ArrayList;

public class TestH {

	public static void main(String[] args) {

		ArrayList<Double> dl = new ArrayList<Double>();
		dl.add(2.4);
		dl.add(3.2);
		dl.add(5.6);
		dl.add(12.23);
		
		for (int i = 0; i < 4; i++) {
			Object c = dl.get(i);
			System.out.println(c);
		}
	}

}
