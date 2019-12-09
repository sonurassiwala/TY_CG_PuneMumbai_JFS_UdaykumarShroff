package com.capgemini.login.factory;

import com.capgemini.login.dao.LoginUserDAO;
import com.capgemini.login.dao.LoginUserDAOJDBCImpl;

public class LoginUserFactory {


	private LoginUserFactory(){

	}

	public static LoginUserDAO getInstance() {
		LoginUserDAO dao = new LoginUserDAOJDBCImpl();
		return dao;
	}


}
