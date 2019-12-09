package com.dev.dummy.controller;

import java.util.Properties;
import java.util.Scanner;

import com.dev.dummy.bean.UserBeanLombok;
import com.dev.dummy.dao.UserDAO;
import com.dev.dummy.dao.UserDAOJDBCImpl;
import com.dev.dummy.factory.UserFactory;
import com.dev.dummy.services.UserServices;
import com.dev.dummy.services.UserValidation;

public class DeleteUser {
	
	static Properties prop = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UserServices us = UserFactory.getServiceImplInstance();
		UserDAOJDBCImpl udi = new UserDAOJDBCImpl();
		UserValidation uv = UserFactory.getValidationInstance();
		UserBeanLombok user = new UserBeanLombok();
		System.out.println("Enter Userid : ");
		String userid = sc.nextLine();
		Boolean b = uv.idValidation(userid);
		if(b) {
			System.out.println("Enter Password : ");
			String password = sc.nextLine();
			
			
				if(udi.deleteUser(password) == true) {
					System.out.println("Data Deleted....");
					System.exit(0);
				}
				else
				{
					System.out.println("Somthing went wrongs");
					System.exit(0);
				}
			
			
		}
		else {
			System.out.println("Enter valid userid...");
			System.exit(0);
		}
		sc.close();
	}

}
