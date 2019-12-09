package com.capgemini.array.genric;

import java.util.Scanner;

public class TestH {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name : ");
		String nm = sc.nextLine();
		
		System.out.print("Enter age : ");
		int a = sc.nextInt();
		
		System.out.print("Enter height : ");
		double h = sc.nextDouble();
		
		System.out.println("Name is : "+nm);
		System.out.println("Age is : "+a);
		System.out.println("Height is : "+h);
		
		sc.close();
	}

}
