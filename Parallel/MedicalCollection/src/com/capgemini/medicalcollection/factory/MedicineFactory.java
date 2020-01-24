package com.capgemini.medicalcollection.factory;

import com.capgemini.medicalcollection.dao.CartDAO;
import com.capgemini.medicalcollection.dao.CartDAOImpli;
import com.capgemini.medicalcollection.dao.MedicineDAO;
import com.capgemini.medicalcollection.dao.MedicineDAOImpli;
import com.capgemini.medicalcollection.dao.MessageDAO;
import com.capgemini.medicalcollection.dao.MessageDAOImpli;
import com.capgemini.medicalcollection.dao.OrderDAO;
import com.capgemini.medicalcollection.dao.OrderDAOImpli;
import com.capgemini.medicalcollection.dao.UserDAO;
import com.capgemini.medicalcollection.dao.UserDAOImpli;
import com.capgemini.medicalcollection.validation.Validation;
import com.capgemini.medicalcollection.validation.ValidationImpl;

public class MedicineFactory {

	private MedicineFactory() {
	}

	public static UserDAO getUserDAO() {
		return new UserDAOImpli();
	}

	public static MedicineDAO getMedicineDAO() {
		return new MedicineDAOImpli();
	}

	public static CartDAO getCartDAO() {
		return new CartDAOImpli();
	}

	public static MessageDAO getMessageDAO() {
		return new MessageDAOImpli();
	}
	
	public static OrderDAO getOrderDAO() {
		return new OrderDAOImpli();
	}
	
	public static Validation getValidate() {
		return new ValidationImpl();
	}
}
