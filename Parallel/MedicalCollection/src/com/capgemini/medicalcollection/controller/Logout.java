package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

public class Logout {
	public void logout() {
		System.out.println("*************************Welcome to Medical Store**********************************");
		System.out.println("Enter Your choice");
		System.out.println("Enter 1 to login");
		System.out.println("Enter 2 to Register");
		System.out.println("Enter 3 to view medicine");
		System.out.println("Enter 4 to Exit");
		int choice = 0;
		try {
			Scanner scan = new Scanner(System.in);
			choice = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Enter Valid Input");
			new Logout().logout();
		}
		switch (choice) {
		case 1:
			new UserController().loginUser();
			break;
		case 2:
			new RegisterUser().userRegister();
			break;
		case 3:
			new ViewMedicine().viewMedicine();
			break;
		case 4:
			System.exit(0);
		default:
			System.err.println("Invalid Input Please Enter Correct InPut");
			break;
		}

	}
}
