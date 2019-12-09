package com.capg.corejava.basics;

public class IncrementDecrement {

	public static void main(String[] args) {
		int i= 10;
		int j =20;
		i = ++i;
		System.out.println(i);
		int k = j++;
		System.out.println(k);
		System.out.println(j);
		
		i = --i;
		System.out.println(i);
		k = j--;
		System.out.println(k);
		System.out.println(j);

	}

}
