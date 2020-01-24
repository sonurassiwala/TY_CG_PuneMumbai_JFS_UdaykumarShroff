package com.capgemini.medicalhibernate.controller;

import java.util.List;

import com.capgemini.medicalhibernate.dao.UserDAO;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;

public class ViewUser {

	public void viewUser() {

		UserDAO dao = MedicalFactory.getUser();
		List<UserBean> ul = dao.getUser();
		System.out.println("----------USERS----------");
		for (UserBean u : ul) {
			System.out.println("User Id : " + u.getUserId());
			System.out.println("User Name : " + u.getUserName());
			System.out.println("User Email : " + u.getUserEmail());
			System.out.println("User password : " + u.getUserPassword());
			System.out.println("User Type : " + u.getUserType());
			System.out.println("-------------------------------------------");

		}
	}
}
