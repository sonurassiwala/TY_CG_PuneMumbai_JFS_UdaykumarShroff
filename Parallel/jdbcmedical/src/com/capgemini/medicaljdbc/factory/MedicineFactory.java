package com.capgemini.medicaljdbc.factory;

import com.capgemini.medicaljdbc.dao.CartDAO;
import com.capgemini.medicaljdbc.dao.CartDAOImpli;
import com.capgemini.medicaljdbc.dao.CartTableDAO;
import com.capgemini.medicaljdbc.dao.CartTableDAOImli;
import com.capgemini.medicaljdbc.dao.MedicineDAO;
import com.capgemini.medicaljdbc.dao.MedicineDAOImpli;
import com.capgemini.medicaljdbc.dao.OrderDAO;
import com.capgemini.medicaljdbc.dao.OrderDAOImpli;
import com.capgemini.medicaljdbc.dao.UserDAO;
import com.capgemini.medicaljdbc.dao.UserDAOImpli;
import com.capgemini.medicaljdbc.validation.MedicalValidation;

public class MedicineFactory {

	private MedicineFactory() {
	}

	public static UserDAO getMedicalDAO() {
		return new UserDAOImpli();
	}

	public static MedicineDAO getMedicineDAO() {
		return new MedicineDAOImpli();
	}

	public static MedicalValidation getMedicalValidation() {
		return new MedicalValidation();
	}

	public static CartDAO getCartDAO() {
		return new CartDAOImpli();
	}

	public static OrderDAO getOrderDao() {
		return new OrderDAOImpli();
	}

	public static CartTableDAO getCartTableDAO() {
		return new CartTableDAOImli();
	}

}
