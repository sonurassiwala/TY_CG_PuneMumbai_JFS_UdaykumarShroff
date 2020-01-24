package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.UserDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class RemoveUser {
	public void removeUser(UserBean userBean) {

		UserDAO dao = MedicineFactory.getUserDAO();
		Validation val = MedicineFactory.getValidate();

		new Viewuser().viewUser();
		System.out.println("Enter user Id want to delete");
		Scanner scan = new Scanner(System.in);
		String uId = scan.nextLine();
		if (val.idValidation(uId)) {
			boolean isDeleted = dao.removeUser(Integer.parseInt(uId));
			if (isDeleted) {
				System.out.println("User Deleted SuccessFully");
				new AdminIndex().adminIndex(userBean);
			} else {
				System.out.println("Enter Valid UserId");
			}
		}else {
			System.out.println("Enter Valid User Id");
		}
	}
}
