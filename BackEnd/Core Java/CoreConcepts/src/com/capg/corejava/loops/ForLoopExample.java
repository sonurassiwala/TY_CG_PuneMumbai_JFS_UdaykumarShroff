package com.capg.corejava.loops;

public class ForLoopExample {

	public static void main(String[] args) {
		
		for (int i =1; i<=10; i++) {
			if(i%2==0)
			{
				System.out.println(i+ " is Even");
			}
			else
			{
				System.out.println(i+" is Odd");
			}
			
		}
		System.out.println("Code outside the for loop");
	}

}
