package com.capgemini.medicaljdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.CartBean;
import com.capgemini.medicaljdbc.bean.MedicineBean;
import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.CartDAO;
import com.capgemini.medicaljdbc.dao.MedicineDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class AddCart {
	public void addCart(UserBean bean) {
		Scanner scan = new Scanner(System.in);
		MedicineDAO dao = MedicineFactory.getMedicineDAO();
		System.out.println("Enter Medicine Id to Add to cart");
		int mid = Integer.parseInt(scan.nextLine());
		int isPresent = 0;
		List<MedicineBean> list = dao.viewmedicine();
		for (MedicineBean medicineBean : list) {
			if (mid == medicineBean.getMedicine_code()) {
				isPresent++;
				CartBean cart = new CartBean();
				cart.setMid(mid);
				cart.setUid(bean.getUserId());
				CartDAO cartDAO = MedicineFactory.getCartDAO();
				if (cartDAO.addTOCart(cart)) {
					System.out.println("Medicine Added Sucessfully");
					new ViewCart().options(bean);
				} else {
					System.out.println("Unable to add medicine");
				}
				break;
			}
		}
		if(isPresent == 0) {
			System.out.println("Invalid MedicineId");
			addCart(bean);
		}
	}
}
