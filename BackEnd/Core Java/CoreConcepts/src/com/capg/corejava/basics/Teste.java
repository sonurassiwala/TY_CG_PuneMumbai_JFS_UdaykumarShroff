package com.capg.corejava.basics;

public class Teste {

	public static void main(String[] args) {
		
		Pen p = new Marker();
		Marker i = (Marker)p;
		
		i.cost = 100;
		i.size = 2.4;
		System.out.println(i.cost);
		System.out.println(i.size);
		i.write();
		i.color();
		
		
	}
	
	
}
