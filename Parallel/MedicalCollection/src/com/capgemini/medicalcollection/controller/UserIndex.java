package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.UserBean;

public class UserIndex {
	public void userIndex(UserBean userBean) {
		while (true) {
			System.out.println("***Welcome " + userBean.getUserName() + "***");
			System.out.println("Enter Your Choice ");
			System.out.println("Press 1 for View Medicine");
			System.out.println("Press 2 for Message");
			System.out.println("Press 3 for Change Password");
			System.out.println("Press 4 for Logout");
			System.out.println("Press 5 to View Cart");
			System.out.println("Press 6 to View OrderHistory");

			int choice = 0;

			try {
				Scanner scan = new Scanner(System.in);
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Enter valid input");
				new UserIndex().userIndex(userBean);
			}

			switch (choice) {
			case 1:
				new ViewMedicine().viewMedicine(userBean);
				break;
			case 2:
				new MessageController().userMessage(userBean);
				break;
			case 3:
				new ChagngePassword().changePassword(userBean);
				break;
			case 4:
				System.out.println("Thankyou Please Visit Again");
				new Logout().logout();
				break;
			case 5:
				new ViewCart().showCart(userBean);
				break;
			case 6:
				new ViewHistory().viewOrder(userBean);
				break;
			default:
				System.err.println("Invalid Input Please Enter Correct InPut");
				break;
			}
		}
	}
}
