package com.capgemini.medicaljdbc.controller;

import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.UserBean;

public class AdminIndex {
	public void choice(UserBean bean) {
		System.out.println("*******************************Welcome to Admin Index************************************");
		System.out.println("Enter Your Choice ");
		System.out.println("Press 1 for Add Medicine");
		System.out.println("Press 2 for View  Medicine");
		System.out.println("Press 3 for Remove  Medicine");
		System.out.println("Press 4 for  update Medicine");
		System.out.println("Press 5 for Add user");
		System.out.println("Press 6 for  View User");
		System.out.println("Press 7 for  Remove User");
		System.out.println("Press 8 to Change Password");
		System.out.println("Press 9 for Logout");

		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());
		switch (choice) {
		case 1:
			new AddMedicine().addMedicine(bean);
			break;
		case 2:
			new ViewMedicine().viewMedicine(bean);
			break;
		case 3:
			new RemoveMedicine().removeMedicine(bean);
			break;
		case 4:
			new UpdateMedicine().updateMedicine(bean);
			break;
		case 5:
			new Register().adminRegister(bean);
			break;
		case 6:
			new ViewUser().viewUser(bean);
			break;
		case 7:
			new RemoveUser().RemoveUser(bean);
			break;
		case 8:
			new ChangePassword().changePassword(bean);
			break;
		case 9:
			System.out.println("Thankyou  Logout SucessFull");
			new Logout().logout();
			break;
		default:
			System.err.println("Invalid OutPut Please Enter Correct OutPut");
			break;
		}

	}
}
