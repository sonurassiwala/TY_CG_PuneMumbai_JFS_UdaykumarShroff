package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.UserDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class RegisterUser {

	public void userRegister() {
		System.out.println(
				"---------------------------------------Welcome to user Registation Page---------------------------------");
		UserDAO dao = MedicineFactory.getUserDAO();
		Validation val = MedicineFactory.getValidate();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter User email");
			String email = scan.nextLine();
			if (val.emailValidation(email)) {
				while (true) {
					System.out.println("Enter User Name");
					String name = scan.nextLine();
					if (val.nameValidation(name)) {
						while (true) {
							System.out.println("Enter Your Password");
							String password = scan.nextLine();
							if (val.passValidation(password)) {

								if (dao.userRegister(email, password, name)) {
									System.out.println("User Registered Successfully");
									new UserController().loginUser();
								}
							} else {
								System.out.println("Enter Valid password");
							}
							new UserController().loginUser();
						}
					} else {
						System.out.println("Enter valid email");
					}
				}
			} else {
				System.out.println("Enter valid email");
			}
		}
	}

	public void adminRegister(UserBean userBean) {
		System.out.println(
				"----Welcome to admin Registation Page----");
		UserDAO dao = MedicineFactory.getUserDAO();
		Validation val = MedicineFactory.getValidate();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter User email");
			String email = scan.nextLine();
			if (val.emailValidation(email)) {
				while (true) {
					System.out.println("Enter User Name");
					String name = scan.nextLine();
					if (val.nameValidation(name)) {
						while (true) {
							System.out.println("Enter Your Password");
							String password = scan.nextLine();
							if (val.passValidation(password)) {
								if (dao.adminRegister(email, password, name)) {
									System.out.println("User Registered Successfully");
									new AdminIndex().adminIndex(userBean);
								}
							}else {
								System.out.println("Enter valid password");
							}
						}
					}else {
						System.out.println("Enter Valid name");
					}
				}
			}else {
				System.out.println("Enter Valid Email");
			}
		}
	}
}
