package com.capg.corejava.loops;

public class WhileLoopExample {

	public static void main(String[] args) {
		int i =5;
		while(i<=20)
		{
			System.out.println("I is : "+i);
			i++;
		}
		System.out.println("Code outside while");
		/*
		 while(true)
		   { 
		   	System.out.println("I is : "+i);
		    i++; 
		   }
		  	System.out.println("Code outside while"); // here it gives error bcoz of condition is given as true
		 */
	}

}
