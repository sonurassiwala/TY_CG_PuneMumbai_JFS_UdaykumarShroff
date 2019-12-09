package com.capgemini.array.genric;

public class RecvString {

	public static void main(String[] args) {

			String d[] = {"Amit", "Suraj", "Rushi", "Niru"};
			
			receive(d);
			
		}

		static void receive(String p[]) {
			
			for(String r : p) {
				System.out.print(" "+r);
			}
			

	}

}
