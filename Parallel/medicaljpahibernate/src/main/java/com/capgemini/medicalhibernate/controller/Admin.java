package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dto.MedicineBean;
import com.capgemini.medicalhibernate.dto.UserBean;

public class Admin {

	public void choice(UserBean userBean) {

		MedicineBean medicineBean = new MedicineBean();
		
		while (true) {
			System.out.println("Welcome to Admin Page");
			System.out.println("Enter Your Choice ");
			System.out.println("Press 1 for Add Medicine");
			System.out.println("Press 2 for View  Medicine");
			System.out.println("Press 3 for Remove  Medicine");
			System.out.println("Press 4 for  Add User");
			System.out.println("Press 5 for  View User");
			System.out.println("Press 6 for Remove User");
			System.out.println("Press 7 for Update Medicine Price");
			System.out.println("Press 8 for Discussion Board");
			System.out.println("Press 9 for Logout");
			int choice = 0;
			try {
				Scanner scan = new Scanner(System.in);
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Enter Valid Input");
				new Admin().choice(userBean);
			}
			switch (choice) {
			case 1:
				new AddMed().addMed(userBean);
				break;
			case 2:
				new ViewMedicine().viewMed();
				break;
			case 3:
				new RemoveMed().removeMed(medicineBean);
				break;
			case 4:
				new Register().adminRegister();
				break;
			case 5:
				new ViewUser().viewUser();
				break;
			case 6:
				new DeleteUser().deleteUser(userBean);
				System.out.println("Successfully Removed..!!");
				break;
			case 7:
				new ChangePrice().chngePrc(medicineBean);
				break;
			case 8:
				new Message().adminmessage(userBean);
				break;
			case 9:
				new Logout().call();
				System.out.println("Successfully Logged Out..!!");
				break;
			default:
				System.err.println("Invalid OutPut Please Enter Correct OutPut");
				break;
			}
		}
	}
	
	
}
