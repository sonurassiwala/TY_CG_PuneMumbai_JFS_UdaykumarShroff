package com.capgemini.medicaljdbc.controller;

import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.UserBean;

public class UserIndex {
	public void choice(UserBean bean) {
		
		System.out.println("Enter Your Choice ");
		System.out.println("Press 1 for View Medicine");
		System.out.println("Press 2 for Disscussion");
		System.out.println("Press 3 for Change Password");
		System.out.println("Press 4 for Logout");
		System.out.println("Press 5 to View Cart");
		System.out.println("Press 6 to View OrderHistory");
		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());
		switch (choice) {
		case 1:
			new ViewMedicine().viewMedicine(bean);
			break;
		case 2:
			new ViewMedicine().viewMedicine(bean);
			break;
		case 3:
			new ChangePassword().changePassword(bean);
			break;
		case 4: System.out.println("Thankyou Please Visit Again");
			break;
		case 5:
			new ViewCart().options(bean);
			break;
		case 6:
			new ViewHistory().ViewHistory(bean);
			break;
		default:
			System.err.println("Invalid OutPut Please Enter Correct OutPut");
			break;
		}
	}
}
