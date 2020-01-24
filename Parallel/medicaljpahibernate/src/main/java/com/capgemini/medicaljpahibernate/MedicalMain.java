package com.capgemini.medicaljpahibernate;

import java.util.Scanner;

import com.capgemini.medicalhibernate.controller.Login;
import com.capgemini.medicalhibernate.controller.Logout;
import com.capgemini.medicalhibernate.controller.Register;
import com.capgemini.medicalhibernate.controller.ViewMedicine;

public class MedicalMain {

	public static void main(String[] args) {

		call();

	}

	public static void call() {
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
				System.err.println("Enter Valid Input");
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
