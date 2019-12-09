package com.capgemini.collectionframework.list;

import java.util.ArrayList;
import java.util.Iterator;

public class TestJ {

	public static void main(String[] args) {

		ArrayList<Double> dl = new ArrayList<Double>();
		dl.add(2.4);
		dl.add(3.2);
		dl.add(5.6);
		dl.add(12.23);
		
		Iterator<Double> id = dl.iterator();
		while(id.hasNext()) {
			Double r = id.next();
			System.out.println(r);
		}
		
	}

}
