package com.capgemini.collectionframework.display;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class TestB {

	public static void main(String[] args) {

		LinkedList<Double> li =new LinkedList<Double>();
		
		li.add(3.6);
		li.add(2.4);
		li.add(4.7);
		li.add(34.7);
		li.add(15.6);
		li.add(34.7);
		li.add(15.6);
			//can accept multiple null
		
		System.out.println("Before "+li);
		
		Collections.shuffle(li);
		
		System.out.println("After "+li);
		
		
		
		/*
		for (int i = 0; i < li.size(); i++) {
			Double r = li.get(i);
			System.out.println(r);
		}*/
		
		
		
	}

}
