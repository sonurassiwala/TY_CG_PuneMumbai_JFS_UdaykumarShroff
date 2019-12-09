package com.capgemini.collectionframework.list;

import java.util.ArrayList;
import java.util.Iterator;

public class TestC 
{

	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		
		al.add(24);
		al.add("Chinuu");
		al.add(2.9);
		al.add('F');
		
		Iterator it = al.iterator();
		
		while(it.hasNext()) 
		{
			Object r = it.next();
			System.out.println(r);
		}
	}

}
