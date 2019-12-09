package com.capgemini.collectionframework.list;

import java.util.ArrayList;

public class TestI {

	public static void main(String[] args) {

		ArrayList<Double> dl = new ArrayList<Double>();
		dl.add(2.4);
		dl.add(3.2);
		dl.add(5.6);
		dl.add(12.23);
		
		for(Double d : dl) {
				System.out.println(d);
			}
		
	}

}
