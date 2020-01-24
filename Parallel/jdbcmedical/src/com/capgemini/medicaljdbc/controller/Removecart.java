package com.capgemini.medicaljdbc.controller;

import com.capgemini.medicaljdbc.dao.CartDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class Removecart {
	public boolean removeMedicine(int cartid) {
		CartDAO dao = MedicineFactory.getCartDAO();
		if (dao.removecart(cartid)) {
			System.out.println("Item Removed from cart");
			return true;
		} else {
			System.out.println("Item not Exist please Enter the Correct Cart id");
		}
		return false;
	}
}
