package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

public class Logout {

	public void call() {
		while (true) {
			System.out.println("******Welcome to Medical Store******");
			System.out.println("Enter Your choice");
			System.out.println("Enter 1 to login");
			System.out.println("Enter 2 to Register");
			System.out.println("Enter 3 to view medicine");
			int choice = 0;
			try {
				Scanner scan = new Scanner(System.in);
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Enter Valid Input");
				new Logout().call();
			}
			switch (choice) {
			case 1:
				new Login().loginUser();
				break;
			case 2:
				new Register().registerUser();
				break;
			case 3:
				new ViewMedicine().viewMed();
				break;

			default:
				System.err.println("Invalid OutPut Please Enter Correct OutPut");
				break;

			}
		}
	}
	
}
