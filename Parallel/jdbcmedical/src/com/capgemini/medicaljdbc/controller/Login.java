package com.capgemini.medicaljdbc.controller;

import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.UserDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class Login {
	public void loginUser() {
		UserDAO dao = MedicineFactory.getMedicalDAO();
		System.out.println("---------------- Welocme To Login Page --------------------------");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter email");
		String email = scan.nextLine();
		System.out.println("Enter password");
		String password = scan.nextLine();
		UserBean bean = dao.loginUser(email, password);
		if(bean != null) {
			System.out.println("Login SucessFull");
			System.out.println("Welcome "+bean.getUserName());
			if(bean.getUserType().equals("admin")) {
				new AdminIndex().choice(bean);
			}
			else if(bean.getUserType().equals("user")) {
				new UserIndex().choice(bean);
			}
			else {
				System.out.println("Invalid ");
			}
		}else {
			System.out.println("Invalid UserName And Password");
		}
		
		
	}
}
