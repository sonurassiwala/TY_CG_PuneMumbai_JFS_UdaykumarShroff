package com.capgemini.medicaljdbc.controller;

import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.UserDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;


public class RemoveUser {
	public void RemoveUser(UserBean bean) {
		Scanner scan = new Scanner(System.in);
		new ViewUser().viewUser();
		System.out.println("Enter UserId you want to delete ");
		int uId = Integer.parseInt(scan.nextLine());
		
		UserDAO dao = MedicineFactory.getMedicalDAO();
		boolean isRemoved = dao.removeUser(uId);
		if(isRemoved) {
			System.out.println("User Removed Sucessfully");
			new AdminIndex().choice(bean);
		}
		else {
			System.out.println("Somthing went Wrong");
			new AdminIndex().choice(bean);
		}

	}

}
