package com.capgemini.medicaljdbc.dao;

import java.util.List;

import com.capgemini.medicaljdbc.bean.UserBean;

public interface MedicalDAO {
	public boolean registerUser(String username, String email, String password);

	public UserBean loginUser(String email, String password);

	public boolean adminRegisterUser(String username, String email, String password,String type);
	public List<UserBean> getuser();

}
