package com.capgemini.jdbc.dao;


import com.capgemini.jdbc.beans.UserBean;

public interface UserDAO {

	//public List<UserBean> getAllInfo();
	public UserBean getInfo(int userid);
	
	
}
