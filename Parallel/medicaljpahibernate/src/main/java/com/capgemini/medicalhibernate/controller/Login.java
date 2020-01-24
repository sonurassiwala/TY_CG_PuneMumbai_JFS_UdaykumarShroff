package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.UserDAO;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.MedicalMain;
import com.capgemini.medicaljpahibernate.validation.Validation;

public class Login {

	public void loginUser() {
		UserDAO dao = MedicalFactory.getUser();
		Validation val = MedicalFactory.getValidate();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter email");
			String email = scan.nextLine();
			if (val.emailValidation(email)) {
				while (true) {
					System.out.println("Enter password");
					String password = scan.nextLine();
					if (val.passValidation(password)) {
						try {
							UserBean bean = dao.loginUser(email, password);
							if (bean != null) {
								System.out.println("Login SucessFull");
								System.out.println("Welcome " + bean.getUserName());
								System.out.println(bean.getUserType());

								if (bean.getUserType().equals("admin")) {
									new Admin().choice(bean);
								}

								else if (bean.getUserType().equals("user")) {
									new User().choice(bean);
								}

								else {
									System.out.println("Invalid ");
								}

							} else {
								System.out.println("Invalid UserName And Password");
								new MedicalMain().call();
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					} else {
						System.out.println("Enter Valid Password");
					}
				}
			} else {
				System.out.println("Enter Valid Email");
			}
		}
	}

}
