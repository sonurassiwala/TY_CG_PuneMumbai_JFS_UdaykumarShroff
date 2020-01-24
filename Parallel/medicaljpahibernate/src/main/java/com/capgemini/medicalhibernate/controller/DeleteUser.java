package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.UserDAO;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.validation.Validation;

public class DeleteUser {

	public boolean deleteUser(UserBean userBean) {

		UserDAO dao = MedicalFactory.getUser();
		Validation val = MedicalFactory.getValidate();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter User-Id to remove");
			String id = sc.nextLine();
			if (val.idValidation(id)) {
				userBean.setUserId(Integer.parseInt(id));
				boolean deleted = dao.deleteUser(userBean);
				if (deleted) {
					System.out.println("Deleted...");
				} else {
					System.out.println("Unable to delete");
				}

				return deleted;
			} else {
				System.out.println("Enter Valid Id");
			}
			return false;
		}
	}
}
