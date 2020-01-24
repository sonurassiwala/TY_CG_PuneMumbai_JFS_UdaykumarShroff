package com.capgemini.medicaljdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.CartBean;
import com.capgemini.medicaljdbc.bean.CartTableBean;
import com.capgemini.medicaljdbc.bean.OrderBean;
import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.CartDAO;
import com.capgemini.medicaljdbc.dao.CartTableDAO;
import com.capgemini.medicaljdbc.dao.OrderDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class PlaceOrder {
	public void placeOrder(double price, UserBean bean, List<CartBean> list) {
		// Place Order
		CartDAO cartDAO = MedicineFactory.getCartDAO();
		OrderDAO orderDAO = MedicineFactory.getOrderDao();
		CartTableDAO cartTableDAO = MedicineFactory.getCartTableDAO();
		CartTableBean cartTableBean = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your Adress");
		String adress = scan.nextLine();
		System.out.println("Enter Your Cardno");
		String cardno = scan.nextLine();
		OrderBean orderBean = new OrderBean();
		if (cardno.length() == 16) {
			orderBean.setPrice(price);
			orderBean.setCardno(cardno);
			orderBean.setAdress(adress);
			orderBean.setUid(bean.getUserId());
			if (orderDAO.placeOrder(orderBean)) {
				System.out.println("Order is getting Placed ");
				int orderId = orderDAO.getMax();

				for (CartBean cartBean : list) {
					cartTableBean = new CartTableBean();
					cartTableBean.setmId(cartBean.getMid());
					cartTableBean.setOrderId(orderId);
					cartTableBean.setPrice(price);

					if (cartTableDAO.addToCartTable(cartTableBean)) {
						if (cartDAO.removecart(cartBean.getCartId())) {

							System.out.println("Hello " + bean.getUserName() + " Your Order Placed SuccessFully ");
							System.out.println("Your Order No. is " + orderId);
							System.out.println("Your Total Bill is " + price);
							System.out.println("Thankyou Please Visit Again");
							new UserIndex().choice(bean);
						}

					}
				}
			} else {

			}
		}

		else {
			System.out.println("Enter the Valid Card no");
		}
	}
}
