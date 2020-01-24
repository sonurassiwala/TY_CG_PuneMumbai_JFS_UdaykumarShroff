package com.capgemini.medicaljdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.MedicineBean;
import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.MedicineDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class ViewMedicine {
	public void viewMedicine() {
		MedicineDAO dao = MedicineFactory.getMedicineDAO();
		List<MedicineBean> list = dao.viewmedicine();
		if (list != null) {
			for (MedicineBean medicineBean : list) {
				System.out.println(medicineBean);
			}
		} else {
			System.out.println("Somthing went Wrong");
		}
	}

	public void viewMedicine(UserBean bean) {
		if (bean.getUserType().equals("admin")) {
			MedicineDAO dao = MedicineFactory.getMedicineDAO();
			List<MedicineBean> list = dao.viewmedicine();
			if (list != null) {
				for (MedicineBean medicineBean : list) {
					System.out.println(medicineBean);
				}
				new AdminIndex().choice(bean);
			} else {
				System.out.println("Somthing went Wrong");
			}
			new AdminIndex().choice(bean);
		} else {
			if (bean.getUserType().equals("user")) {
				MedicineDAO dao = MedicineFactory.getMedicineDAO();
				List<MedicineBean> list = dao.viewmedicine();
				if (list != null) {
					for (MedicineBean medicineBean : list) {
						System.out.println(medicineBean);
					}
					Scanner scan = new Scanner(System.in);
					System.out.println("Enter 1 to Add Item to cart");
					System.out.println("Enter 2 to Logout");
					int choice = Integer.parseInt(scan.nextLine());
					switch (choice) {
					case 1:
						new AddCart().addCart(bean);
						break;
					case 2:
						System.exit(0);
					}
				} else {
					System.out.println("Somthing went Wrong");
				}
			}
			new UserIndex().choice(bean);
		}
		
	}
}
