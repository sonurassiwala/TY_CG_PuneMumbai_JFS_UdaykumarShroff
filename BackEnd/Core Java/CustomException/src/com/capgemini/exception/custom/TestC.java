package com.capgemini.exception.custom;

import java.util.Scanner;

public class TestC {

	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in))
		{
			System.out.print("Enter age : ");
			int age = sc.nextInt();
			System.out.println("Age is : "+age);
		}
	}

}
