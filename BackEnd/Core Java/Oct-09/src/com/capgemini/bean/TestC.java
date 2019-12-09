package com.capgemini.bean;

public class TestC {

	public static void main(String[] args) {

		Van r = Van.getVan();
		System.out.println("From r : "+r);
		
		Van t = Van.getVan();
		System.out.println("From t : "+t);
		
		Van s = Van.getVan();
		System.out.println("From s : "+s);
		
	}

}
