package com.capgemini.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean userRegistration(UserBean userBean) {
		return userDAO.userRegistration(userBean);
	}

	@Override
	public UserBean userLogin(String email, String password) {
		return userDAO.userLogin(email, password);
//		if (userDAO.emailPresent(email)) {
//		} else {
//			throw new EmailNotExistException();
//		}

	}

	@Override
	public boolean resetPassword(String email, String phoneNumber, String password) {
		return userDAO.resetPassword(email, phoneNumber, password);
	}

	@Override
	public boolean updateProfile(UserBean userBean) {
		return userDAO.updateProfile(userBean);
	}

	@Override
	public UserBean showProfile(int userId) {
		return userDAO.showProfile(userId);
	}

	@Override
	public List<UserBean> showManager() {
		return userDAO.showManager();
	}

	@Override
	public List<UserBean> showUser() {
		return userDAO.showUser();
	}

	@Override
	public boolean removeUser(int userId) {
		return userDAO.removeUser(userId);
	}

	@Override
	public boolean emailPresent(String email) {
		return userDAO.emailPresent(email);
	}

	@Override
	public boolean passwordChecker(String email, String password) {
		return userDAO.passwordChecker(email, password);
	}

	
}// End of Class
