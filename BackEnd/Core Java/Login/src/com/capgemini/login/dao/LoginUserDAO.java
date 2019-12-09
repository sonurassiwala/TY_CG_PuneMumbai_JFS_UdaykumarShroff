package com.capgemini.login.dao;

import java.util.List;

import com.capgemini.login.beans.LoginUserBean;

public interface LoginUserDAO {

	public List<LoginUserBean> getAllInfo();
	public LoginUserBean getInfo(int userid);
	public LoginUserBean userLogin(int userid, String password);
	
}
