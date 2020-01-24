package com.capgemini.hotelmanagement.service;

import java.util.List;

import com.capgemini.hotelmanagement.beans.UserBean;

public interface UserService {

	public boolean userRegistration(UserBean userBean);

	public UserBean userLogin(String email, String password);

	public boolean resetPassword(String email, String phoneNumber, String password);

	public boolean updateProfile(UserBean userBean);

	public UserBean showProfile(int userId);

	public List<UserBean> showManager();

	public List<UserBean> showUser();

	public boolean removeUser(int userId);

	public boolean emailPresent(String email);
	
	public boolean passwordChecker(String email, String password);

}
