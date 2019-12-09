package com.capg.corejava.cfs;

public class IfElseIf {

	public static void main(String[] args) {
		int marks = 15;
		if(marks>=75)		//if is compulsory
		{
			System.out.println("Grade A");
		}
		else if(marks>=50 && marks<75)
		{
			System.out.println("Grade B");
		}
		else if(marks<50 && marks >=20)
		{
			System.out.println("Grade C");
		}
		
		else		//Not necessary
		{
			System.out.println("Fail");
		}
		
	}

}
