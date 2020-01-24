package com.capgemini.medicalcollection.controller;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.medicalcollection.bean.CartBean;
import com.capgemini.medicalcollection.bean.MedicineBean;
import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.CartDAO;
import com.capgemini.medicalcollection.dao.MedicineDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;

public class ViewCart {
	public void showCart(UserBean bean) {
		CartDAO cDao = MedicineFactory.getCartDAO();
		MedicineDAO mDao = MedicineFactory.getMedicineDAO();
		List<CartBean> cartList = cDao.getCart(bean.getUserId());
		List<MedicineBean> medList = mDao.getMedicine();
		double price = 0;
		if (cartList != null && !cartList.isEmpty()) {
			for (CartBean cartBean : cartList) {
				for (MedicineBean medicineBean : medList) {
					if (cartBean.getMedicineId() == medicineBean.getMedicineCode() && cartBean.getUserId()==bean.getUserId()) {
						System.out.println(" CartId is " + cartBean.getCartId() + " Medicine Name "
								+ medicineBean.getMedicineName() + " Price " + medicineBean.getPrice());
						price = price + medicineBean.getPrice();
					}
				}
			}
			System.out.println("Your Total Bill is " + price);
			System.out.println("Press 1 to Remove Item  From Cart");
			System.out.println("Press 2 to Place Order");
			System.out.println("Press 3 to Continue to Cart");
			System.out.println("Press any key continue to ");
			
			int choice = 0;
			
			try {
				Scanner scan = new Scanner(System.in);
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Enter Valid Input");
				new ViewCart().showCart(bean);
			}
			
			if (choice == 1) {
				new RemoveCart().removeCart(bean);
			} else if (choice == 2) {
				new PlaceOrder().placeOrder(bean, price);
			} else if (choice == 3) {
				new AddToCart().addTOCart(bean);
			} else {
				new UserIndex().userIndex(bean);
			}

		} else {
			System.out.println("No Item Present In Cart");
			new AddToCart().addTOCart(bean);
		}
	}
}
