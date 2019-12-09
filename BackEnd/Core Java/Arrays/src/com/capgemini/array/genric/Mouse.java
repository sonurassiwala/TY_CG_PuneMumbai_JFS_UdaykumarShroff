package com.capgemini.array.genric;

public class Mouse {


		void walk(double[] a) {
			
			for(double p : a) {
				System.out.println("Double value : "+p);
			}
			
		}
		
		void run(int[] a) {
			
			for(int i = 0; i<a.length; i++) {
				System.out.println("Integer value : "+a[i]);
			}
			
		}
		
	

}
