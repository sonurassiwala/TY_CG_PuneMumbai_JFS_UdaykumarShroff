package com.capgemini.medicalcollection.dao;

import java.util.List;

import com.capgemini.medicalcollection.bean.UserBean;

public interface UserDAO {
	public UserBean login(String email, String password);

	public boolean userRegister(String email, String password, String name);

	public boolean adminRegister(String email, String password, String name);

	List<UserBean> getUsers();

	public boolean removeUser(int uid);

	boolean changePassword(UserBean bean, String pass);
}
