package com.capgemini.medicalhibernate.controller;

import com.capgemini.medicalhibernate.dao.CartDAO;
import com.capgemini.medicalhibernate.dto.CartBean;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;

public class RemoveCart {

	public boolean removeCart(int id) {
		
		UserBean userBean = new UserBean();
		CartDAO dao = MedicalFactory.getcart();
		if(dao.removeCart(id)) {
			System.out.println("Order Successfull");
			System.out.println("-----------------------------------");
			return true;
		}
		return false;
	}
	
}
