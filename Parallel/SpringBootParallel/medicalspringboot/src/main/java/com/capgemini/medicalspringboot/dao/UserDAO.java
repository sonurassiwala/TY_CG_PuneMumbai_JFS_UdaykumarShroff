package com.capgemini.medicalspringboot.dao;

import java.util.List;

import com.capgemini.medicalspringboot.bean.UserBean;

public interface UserDAO {

	public UserBean getUser(int userId);
	public UserBean loginUser(String email, String password);
	public boolean addUser(UserBean userBean);
	public boolean updateUser(UserBean userBean);
	public boolean deleteUser(int userId);
	public List<UserBean> getAllUser();
}
