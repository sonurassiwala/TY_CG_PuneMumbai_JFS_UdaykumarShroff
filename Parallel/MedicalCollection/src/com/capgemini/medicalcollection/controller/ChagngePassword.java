package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.UserDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class ChagngePassword {
	public void changePassword(UserBean userBean) {
		UserDAO dao = MedicineFactory.getUserDAO();
		Validation val = MedicineFactory.getValidate();
		while (true) {
			System.out.println("Enter Your New password");
			Scanner scan = new Scanner(System.in);
			String pass = scan.nextLine();
			if (val.passValidation(pass)) {
				if (dao.changePassword(userBean, pass)) {
					System.out.println("Password Changes Successfully");
					if (userBean.getUserType().equals("admin")) {
						new AdminIndex().adminIndex(userBean);
					} else {
						new UserIndex().userIndex(userBean);
					}
				} else {
					System.out.println("Unable To change password");
					new AdminIndex().adminIndex(userBean);
				}
			} else {
				System.out.println("Enter valid password");
			}
		}
	}
}
