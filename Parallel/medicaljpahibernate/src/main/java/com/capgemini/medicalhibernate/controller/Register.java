package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.UserDAO;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.MedicalMain;
import com.capgemini.medicaljpahibernate.validation.Validation;

public class Register {

	public void registerUser() {

		UserDAO dao = MedicalFactory.getUser();
		Validation val = MedicalFactory.getValidate();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter User Name");
			String userName = scanner.nextLine();
			if (val.nameValidation(userName)) {
				while (true) {
					System.out.println("Enter User Email");
					String email = scanner.nextLine();
					if (val.emailValidation(email)) {
						while (true) {
							System.out.println("Enter use Password");
							String password = scanner.nextLine();
							if (val.passValidation(password)) {
								
									boolean added = dao.registerUser(userName, email, password);
									if (added) {
										System.out.println("User is registerd Successfully");
									} else {
										System.out.println("Somthing wents Wrong");
									}
								
								new Login().loginUser();
							} else {

								System.out.println("Enter Valid Password");
							}
						}
					} else {

						System.out.println("Enter valid Email");
					}
				}
			} else {

				System.out.println("Enter Valid name");
			}
		}
	}

	public void adminRegister() {

		UserBean userBean = new UserBean();
		UserDAO dao = MedicalFactory.getUser();
		Validation val = MedicalFactory.getValidate();
		Scanner scanner = new Scanner(System.in);
		String type = null;
		while (true) {
			System.out.println("Enter User Name");
			String userName = scanner.nextLine();
			if (val.nameValidation(userName)) {
				while (true) {
					System.out.println("Enter User Email");
					String email = scanner.nextLine();
					if (val.emailValidation(email)) {
						while (true) {
							System.out.println("Enter use Password");
							String password = scanner.nextLine();
							if (val.passValidation(password)) {
								while (true) {
									System.out.println("Enter use type ");
									System.out.println("Press 1 for Admin");
									System.out.println("Press 2 for Normal User");
									int choice = 0;
									try {
										choice = Integer.parseInt(scanner.nextLine());
									} catch (NumberFormatException e) {
										System.out.println("Enter Valid Input");
									}
									switch (choice) {
									case 1:
										type = "admin";
										break;
									case 2:
										type = "user";
										break;

									}

									boolean added = dao.adminRegisterUser(userName, email, password, type);
									if (added) {
										System.out.println("User is registerd Successfully");
									} else {
										System.out.println("Somthing wents Wrong");
									}

									new Admin().choice(userBean);

								}
							} else {
								System.out.println("Enter valid password");
							}
						}
					} else {
						System.out.println("Enter Valid name");
					}
				}
			} else {
				System.out.println("Enter Valid Name");
			}
		}
	}
}
