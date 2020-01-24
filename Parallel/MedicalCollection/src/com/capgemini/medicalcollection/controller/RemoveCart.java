package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.CartDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class RemoveCart {
	public void removeCart(UserBean bean) {
		CartDAO cDao = MedicineFactory.getCartDAO();
		Validation val = MedicineFactory.getValidate();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter CartId ");
			String cartId = scan.nextLine();
			if (val.idValidation(cartId)) {
				boolean isRemoved = cDao.removecart(Integer.parseInt(cartId));
				if (isRemoved) {
					System.out.println("Item Removed SuccessFul");
				} else {
					System.out.println("Please Enter Correct CartID");
				}
				new UserIndex().userIndex(bean);
			}else {
				System.out.println("Enter Valid Cart Id");
			}
		}
	}
}
