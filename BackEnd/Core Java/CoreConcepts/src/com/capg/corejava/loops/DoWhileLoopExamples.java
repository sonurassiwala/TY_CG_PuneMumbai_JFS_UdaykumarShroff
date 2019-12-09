package com.capg.corejava.loops;

public class DoWhileLoopExamples {

	public static void main(String[] args) {
		int i =11;
		do {
			System.out.println("i is : "+i);
			i++;
		} while (i<=10);
		System.out.println("Code Outside the do-while loop");
		/*
		 * do 
		 * { 
		 * System.out.println("i is : "+i); 
		 * i++; 
		 * } 
		 * while (true);
		 * System.out.println("Code Outside the do-while loop");  //here also it will give error bcoz of condition is true
		 */
	}

}
