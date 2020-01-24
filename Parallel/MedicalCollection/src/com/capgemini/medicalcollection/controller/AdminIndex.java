package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.UserBean;

public class AdminIndex {
	public void adminIndex(UserBean userBean) {
		int choice = 0;
		System.out.println("Welcome " + userBean.getUserName());
		System.out.println("Enter Your Choice ");
		System.out.println("Press 1 for Add Medicine");
		System.out.println("Press 2 for View  Medicine");
		System.out.println("Press 3 for Remove  Medicine");
		System.out.println("Press 4 for  update Medicine price");
		System.out.println("Press 5 for Add user");
		System.out.println("Press 6 for  View User");
		System.out.println("Press 7 for  Remove User");
		System.out.println("Press 8 to Change Password");
		System.out.println("Press 9 for Message");
		System.out.println("Press 10 for Logout");

		try {
			Scanner scan = new Scanner(System.in);
			choice = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.err.println("Enter Valid Input");
			new AdminIndex().adminIndex(userBean);
		}
		switch (choice) {
		case 1:
			new AddMedicine().addMedicine(userBean);
			break;
		case 2:
			new ViewMedicine().viewMedicine(userBean);
			break;
		case 3:
			new RemoveMedicine().removeMedicine(userBean);
			break;
		case 4:
			 new UpdatePrice().updatePrice(userBean);
			break;
		case 5:
			new RegisterUser().adminRegister(userBean);
			break;
		case 6:
			new Viewuser().viewUser(userBean);
			break;
		case 7:
			new RemoveUser().removeUser(userBean);
			break;
		case 8:
			new ChagngePassword().changePassword(userBean);
			break;
		case 9:
			 new MessageController().adminMessage(userBean);
		case 10:
			System.out.println("Thankyou  Logout SucessFull");
			new Logout().logout();
			break;
		default:
			System.err.println("Invalid OutPut Please Enter Correct OutPut");
			// new AdminIndex().choice(bean);
			break;
		}

	}

}
