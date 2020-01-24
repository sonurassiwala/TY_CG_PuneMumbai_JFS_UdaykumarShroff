package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.UserDAO;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.validation.Validation;

public class ChangePassword {

	public boolean change(UserBean user) {
		UserDAO dao = MedicalFactory.getUser();
		Validation val = MedicalFactory.getValidate();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter user Password");
			String pswd = sc.nextLine();
			if (val.passValidation(pswd)) {
				user.setUserPassword(pswd);
				boolean setted = dao.changePassword(user);
				if (setted) {
					System.out.println("changed");
				} else {
					System.out.println("no");
				}

				return setted;
			} else {
				System.out.println("Enter Valid Password");
				new ChangePassword().change(user);
			}
			return false;
		}
	}
}
