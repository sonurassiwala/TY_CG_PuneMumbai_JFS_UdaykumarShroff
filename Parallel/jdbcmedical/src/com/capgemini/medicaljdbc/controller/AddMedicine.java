package com.capgemini.medicaljdbc.controller;

import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.MedicineBean;
import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.MedicineDAO;
import com.capgemini.medicaljdbc.dao.UserDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class AddMedicine {
	public void addMedicine(UserBean bean1) {
		
		MedicineBean bean = new MedicineBean();
		MedicineDAO dao = MedicineFactory.getMedicineDAO();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Medicine Name");
		String medicine_name = sc.nextLine();
		System.out.println("Enter Medicine Price ");
		double price = Double.parseDouble(sc.nextLine());
		System.out.println("Enter product_catgegory ");
		String product_category = sc.nextLine();
		bean.setMedicine_name(medicine_name);
		bean.setPrice(price);
		bean.setProduct_category(product_category);
		boolean added  = dao.addMedicine(bean);
		if (added) {
			System.out.println("User is registerd Successfully");
		} else {
			System.out.println("Somthing wents Wrong");
		}
		new AdminIndex().choice(bean1);
	}
}
