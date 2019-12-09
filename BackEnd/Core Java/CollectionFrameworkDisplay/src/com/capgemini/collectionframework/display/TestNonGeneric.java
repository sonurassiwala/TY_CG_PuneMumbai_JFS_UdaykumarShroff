package com.capgemini.collectionframework.display;

import java.util.ArrayList;
import java.util.Collections;

public class TestNonGeneric {

	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		
		al.add('W');
		al.add('D');
		al.add('R');
		al.add('Z');
		
		Collections.sort(al);	//ClassCastException
		
		System.out.println(al);
		
	}

}
