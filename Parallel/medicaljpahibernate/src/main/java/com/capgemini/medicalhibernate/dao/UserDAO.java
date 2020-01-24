package com.capgemini.medicalhibernate.dao;

import java.util.List;

import com.capgemini.medicalhibernate.dto.UserBean;

public interface UserDAO {

	public UserBean loginUser(String email, String password);
	public boolean registerUser(String name, String email, String password);
	public  boolean deleteUser(UserBean userBean);
	public List<UserBean> getUser();
	public boolean adminRegisterUser(String name, String email, String password, String type);
	public boolean changePassword(UserBean userBean);
}
