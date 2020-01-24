package com.capgemini.medicalcollection.database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.medicalcollection.bean.UserBean;

public class UserDataBase {
	static List<UserBean> userBeans = new ArrayList<UserBean>();

	static {
		UserBean u1 = new UserBean(100, "Uday", "uday", "admin", "uday@gmail.com");
		UserBean u2 = new UserBean(101, "Jagnish", "jagnish", "user", "jagnish@gmail.com");
		UserBean u3 = new UserBean(102, "Amit", "amit","user", "amit@gmail.com");
		UserBean u4 = new UserBean(103, "Suraj", "suraj","user", "suraj@gmail.com");
		userBeans.add(u1);
		userBeans.add(u2);
		userBeans.add(u3);
		userBeans.add(u4);
	}

	public List<UserBean> getUser() {
		return userBeans;
	}
}
