package com.capgemini.array.genric;

interface Gm{
	
	void gm();
	
}

public class LambaGM {

	public static void main(String[] args) {

	Gm g = () -> System.out.println("Good Morning");
	g.gm();
		
	}

}
