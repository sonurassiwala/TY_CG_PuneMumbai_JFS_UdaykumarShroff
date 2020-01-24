package com.capgemini.medicalhibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.CartDAO;
import com.capgemini.medicalhibernate.dto.CartBean;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;

public class ViewCart {

	public void vCart(UserBean bean) {

		CartDAO cdao = MedicalFactory.getcart();
		List<CartBean> cl = cdao.getCart(bean.getUserId());
		int price = 0;
		System.out.println("----------Cart----------");
		for (CartBean c : cl) {
			System.out.println("Cart Id : " + c.getCartId());
			System.out.println("User Id : " + c.getUserId());
			System.out.println("Medicine Code : " + c.getMedicineCode());
			System.out.println("Medicine Price : " + c.getMedicinePrice());
			System.out.println("-------------------------------------------");
			price = price + c.getMedicinePrice();
		}
		
		System.out.println("Your Bill is : " + price);
		System.out.println("-------------");
		System.out.println("Select option \n1. Pay Bill\n2. Continue to your page");
		Scanner scan = new Scanner(System.in);
		int choice = Integer.parseInt(scan.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Enter Your Cardno");
			String cardno = scan.nextLine();
			if (cardno.length() == 16) {
				System.out.println("Enter Your CVV");
				String cvv = scan.nextLine();
				if (cvv.length() == 3) {
					System.out.println("Payment Successfull of Rs. " + price);
					new AddOrder().addOrder(bean.getUserId(), cardno, price, cvv);
					new RemoveCart().removeCart(bean.getUserId());
				}
			} else {
				System.out.println("Card no. is Invalid..!!");
					System.out.println("Enter Your Cardno");
					String cardno1 = scan.nextLine();
					if (cardno1.length() == 16) {
						System.out.println("Enter Your CVV");
						String cvv = scan.nextLine();
						if (cvv.length() == 3) {
							System.out.println("Payment Successfull of Rs. " + price);
							new AddOrder().addOrder(bean.getUserId(), cardno, price, cvv);
							new RemoveCart().removeCart(bean.getUserId());
						}
						
				}
						
			}
		case 2 :
			new User().choice(bean);
			break;
		}
	}

}
