package com.capgemini.jdbc.factory;

import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.dao.UserDAOJDBCImpl;

public class UserFactory {

	private UserFactory(){
		
	}
	
	public static UserDAO getInstance() {
		UserDAO dao = new UserDAOJDBCImpl();
		return dao;
	}
	
}
