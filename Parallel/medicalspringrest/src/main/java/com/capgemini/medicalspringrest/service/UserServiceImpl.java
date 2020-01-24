package com.capgemini.medicalspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringrest.bean.UserBean;
import com.capgemini.medicalspringrest.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	@Override
	public UserBean getUserId(int userId) {

		return dao.getUser(userId);
	}

	@Override
	public UserBean loginUser(String email, String password) {
		
		return dao.loginUser(email, password);
		
	}

	@Override
	public boolean addUser(UserBean userBean) {
		return dao.addUser(userBean);
	}

	@Override
	public boolean updateUser(UserBean userBean) {
		return dao.updateUser(userBean);
	}

	@Override
	public boolean deleteUser(int userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public List<UserBean> getAllUser() {
		return dao.getAllUser();
	}

}
