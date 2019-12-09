package com.capgemini.array.genric;

public class IntValues {

	public static void main(String[] args) {

		int[] n = new int[4];
		n[0] = 2;
		n[1] = 4;
		n[2] = 6;
		n[3] = 8;
	//	n[4] = 10;		//ArrayIndexOutofBondException
		
		System.out.println("Size of an Array : "+n.length);
		
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i]);
		}
		
	}

}
