package com.capgemini.login.dao;

import java.util.List;

import com.capgemini.login.beans.LoginUserBean;
import com.capgemini.login.factory.LoginUserFactory;

public class GetAllInfo {

	public static void main(String[] args) {

		LoginUserDAO dao = LoginUserFactory.getInstance();
		List<LoginUserBean> userlist = dao.getAllInfo();
		if(userlist != null) {
			for(LoginUserBean user : userlist) {
				System.out.println(user);
			}
		}else {
			System.out.println("Something went wrong....");
		}
		
		
	}

}
