package com.capgemini.medicaljdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.CartBean;
import com.capgemini.medicaljdbc.bean.MedicineBean;
import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.CartDAO;
import com.capgemini.medicaljdbc.dao.MedicineDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class ViewCart {
	public void options(UserBean bean) {
		CartDAO dao = MedicineFactory.getCartDAO();
		double price = 0;
		MedicineDAO meddao = MedicineFactory.getMedicineDAO();
		Scanner scan = new Scanner(System.in);
		List<CartBean> list = dao.getAll(bean.getUserId());
		if (list != null && !list.isEmpty()) {
			for (CartBean cartBean : list) {
				MedicineBean medBean = meddao.getMed(cartBean.getMid());
				System.out.println("Name =" + medBean.getMedicine_name() + "Medicine Id = " + medBean.getMedicine_code()
						+ "CartId = " + cartBean.getCartId() + "Price = " + medBean.getPrice() + "category ="
						+ medBean.getProduct_category());

				price = price + medBean.getPrice();
			}
			System.err.println("********************************************************************");
			System.out.println("Your Bill is " + price);
			System.out.println("Enter 1 to Continue to Shop");
			System.out.println("Enter 2 to remove From cart");
			System.out.println("Enter 3 to Place OrderDAO");

			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				new AddCart().addCart(bean);
				break;

			case 2:
				System.out.println("Enter cartId want to delete");
				int cartid = Integer.parseInt(scan.nextLine());
				new Removecart().removeMedicine(cartid);
				options(bean);
			case 3:
				new PlaceOrder().placeOrder(price, bean, list);
			}
		} else {
			System.out.println("You have no Item in your Cart");
			new AddCart().addCart(bean);
		}
		
	}
}
