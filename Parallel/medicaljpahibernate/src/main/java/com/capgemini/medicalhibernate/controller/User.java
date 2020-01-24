package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dto.UserBean;

public class User {

	public void choice(UserBean userBean) {
		while (true) {
			System.out.println("Enter Your Choice ");
			System.out.println("Press 1 for View Medicine");
			System.out.println("Press 2 for Add Medicine to Cart");
			System.out.println("Press 3 for Change Password");
			System.out.println("Press 4 for View Cart");
			System.out.println("Press 5 for View Your Order");
			System.out.println("Press 6 for Discussion Board");
			System.out.println("Press 7 for Logout");
			int choice = 0;
			try {
				Scanner scan = new Scanner(System.in);
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Enter Valid input");
				new User().choice(userBean);
			}
			switch (choice) {
			case 1:
				new ViewMedicine().viewMed();
				break;
			case 2:
				new AddCart().addtoCart(userBean);
				break;
			case 3:
				new ChangePassword().change(userBean);
				break;
			case 4:
				new ViewCart().vCart(userBean);
				break;
			case 5:
				new ViewOrder().viewOrder(userBean);
				break;
			case 6:
				new Message().usermessage(userBean);
				break;
			case 7:
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
