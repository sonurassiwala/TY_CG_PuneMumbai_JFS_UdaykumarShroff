package com.capg.corejava.inheritance;

public class Testa {

	public static void main(String [] args) {
		
		Lays r = new Lays();
		Kurkure k = new Kurkure();
		Bingo p = new Bingo();
		
		Baby b = new Baby();
		b.receive(k);
	}
}
