package com.capgemini.medicalcollection.controller;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.medicalcollection.bean.MedicineBean;
import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.MedicineDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;

public class ViewMedicine {
	public void viewMedicine() {
		MedicineDAO dao = MedicineFactory.getMedicineDAO();
		List<MedicineBean> medlist = dao.getMedicine();
		if (medlist != null) {
			for (MedicineBean medicineBean : medlist) {
				System.out.println(medicineBean);
			}
		} else {
			System.out.println("Somthing went Wrong");
		}
		new Logout().logout();
	}

	public void viewMedicine(UserBean bean) {
		if (bean.getUserType().equals("admin")) {
			MedicineDAO dao = MedicineFactory.getMedicineDAO();
			List<MedicineBean> medlist = dao.getMedicine();
			if (medlist != null) {
				for (MedicineBean medicineBean : medlist) {
					System.out.println(medicineBean);
				}
				new AdminIndex().adminIndex(bean);
			} else {
				System.out.println("Somthing went Wrong");
			}
			new AdminIndex().adminIndex(bean);
		} else {
			if (bean.getUserType().equals("user")) {
				MedicineDAO dao = MedicineFactory.getMedicineDAO();
				List<MedicineBean> medlist = dao.getMedicine();
				if (medlist != null) {
					for (MedicineBean medicineBean : medlist) {
						System.out.println(medicineBean);
					}
					Scanner scan = new Scanner(System.in);
					System.out.println("Enter 1 to Add Item to cart");
					System.out.println("Enter 2 to Logout");
					int choice = Integer.parseInt(scan.nextLine());
					switch (choice) {
					case 1:
						new AddToCart().addTOCart(bean);
						break;
					case 2:
						System.exit(0);
						break;
					default:
						System.out.println("Enter Correct Input");
						new UserIndex().userIndex(bean);
					}
				} else {
					System.out.println("Somthing went Wrong");
				}
			}
		}
		new UserIndex().userIndex(bean);
	}
}
