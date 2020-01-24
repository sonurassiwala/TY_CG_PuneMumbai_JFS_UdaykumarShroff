package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.OrderBean;
import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.CartDAO;
import com.capgemini.medicalcollection.dao.OrderDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class PlaceOrder {
	public void placeOrder(UserBean userBean, double price) {
		Scanner scan = new Scanner(System.in);
		OrderDAO dao = MedicineFactory.getOrderDAO();
		CartDAO cdao = MedicineFactory.getCartDAO();
		Validation val = MedicineFactory.getValidate();
		while (true) {
			System.out.println("Enter Your Adress");
			String add = scan.nextLine();
			if (val.nameValidation(add)) {
				System.out.println("Enter Card no.");
				String cardNo = scan.nextLine();
				if (val.cardValidation(cardNo)) {
					OrderBean orderBean = new OrderBean();
					orderBean.setAddress(add);
					orderBean.setCardno(cardNo);
					orderBean.setPrice(price);
					orderBean.setUserId(userBean.getUserId());
					if (dao.placeOrder(orderBean)) {
						System.out.println("Order Placed SuccessFully");
						cdao.removeAllCart(userBean.getUserId());
						new UserIndex().userIndex(userBean);
					} else {
						System.out.println("Unable to place Order");
						new UserIndex().userIndex(userBean);
					}
				} else {
					System.out.println("Enter Correct Card no.");
					new PlaceOrder().placeOrder(userBean, price);
				}
			} else {
				System.out.println("Enter Correct Address");
			}
		}
	}
}
