package com.capgemini.medicalcollection.controller;

import java.util.List;
import java.util.Set;

import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.UserDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;

public class Viewuser {
	public void viewUser(UserBean bean) {
		UserDAO userDAO = MedicineFactory.getUserDAO();
		List<UserBean> userList = userDAO.getUsers();
		if(userList != null && !userList.isEmpty()) {
			for (UserBean userBean : userList) {
				System.out.println("-------------------------------------------------------------------------------------------");
				System.out.println(userBean.getUserId());
				System.out.println(userBean.getUserName());
				System.out.println(userBean.getUserEmail());
				System.out.println(userBean.getUserPassword());
				System.out.println(userBean.getUserType());
			}
		}
		new AdminIndex().adminIndex(bean);
	}
	public void viewUser() {
		UserDAO userDAO = MedicineFactory.getUserDAO();
		List<UserBean> userList = userDAO.getUsers();
		if(userList != null && !userList.isEmpty()) {
			for (UserBean userBean : userList) {
				System.out.println("-------------------------------------------------------------------------------------------");
				System.out.println(userBean.getUserId());
				System.out.println(userBean.getUserName());
				System.out.println(userBean.getUserEmail());
				System.out.println(userBean.getUserPassword());
				System.out.println(userBean.getUserType());
			}
		}
	}
}
