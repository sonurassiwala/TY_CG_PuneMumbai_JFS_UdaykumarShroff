package com.capgemini.medicalcollection.main;

import java.util.Scanner;

import com.capgemini.medicalcollection.controller.Logout;
import com.capgemini.medicalcollection.controller.RegisterUser;
import com.capgemini.medicalcollection.controller.UserController;
import com.capgemini.medicalcollection.controller.ViewMedicine;

public class CollectionMain {
	public static void main(String[] args) {
		while (true) {
			System.out.println("***Welcome to Medical Store***");
			System.out.println("Enter Your choice");
			System.out.println("Enter 1 to login");
			System.out.println("Enter 2 to Register");
			System.out.println("Enter 3 to view medicine");
			System.out.println("Enter 4 to Exit");
			int choice = 0;
			try {
				Scanner scan = new Scanner(System.in);
				choice = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.err.println("Enter valid Input");
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

}
