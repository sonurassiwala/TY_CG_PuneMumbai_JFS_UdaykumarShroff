package com.capgemini.medicalhibernate.factory;

import com.capgemini.medicalhibernate.dao.CartDAO;
import com.capgemini.medicalhibernate.dao.CartDAOImpl;
import com.capgemini.medicalhibernate.dao.MedicineDAOImpl;
import com.capgemini.medicalhibernate.dao.MedicneDAO;
import com.capgemini.medicalhibernate.dao.MessageDAO;
import com.capgemini.medicalhibernate.dao.MessageDAOImpl;
import com.capgemini.medicalhibernate.dao.OrderDAO;
import com.capgemini.medicalhibernate.dao.OrderDAOImpl;
import com.capgemini.medicalhibernate.dao.UserDAO;
import com.capgemini.medicalhibernate.dao.UserDAOImpl;
import com.capgemini.medicaljpahibernate.validation.Validation;
import com.capgemini.medicaljpahibernate.validation.ValidationImpl;

public class MedicalFactory {

	private MedicalFactory() {
		super();
	}
	
	public static UserDAO getUser() {
		return new UserDAOImpl();
	}
	
	public static MedicneDAO getMedicine() {
		return new MedicineDAOImpl();
	}
	
	public static CartDAO getcart() {
		return new CartDAOImpl();
	}
	
	public static MessageDAO getMessage() {
		return new MessageDAOImpl();
	} 
	
	public static OrderDAO getOrder() {
		return new OrderDAOImpl();
	}
	
	public static Validation getValidate() {
		return new ValidationImpl();
	}
	
}
