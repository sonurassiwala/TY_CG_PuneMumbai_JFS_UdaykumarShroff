package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.MedicineBean;
import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.MedicineDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class AddMedicine {
	public void addMedicine(UserBean bean1) {

		MedicineBean bean = new MedicineBean();
		MedicineDAO dao = MedicineFactory.getMedicineDAO();
		Validation val = MedicineFactory.getValidate();

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Medicine Name");
			String medicineName = sc.nextLine();
			if (val.nameValidation(medicineName)) {
				while (true) {
					System.out.println("Enter Medicine Price ");
					String price = sc.nextLine();
					if (val.priceValidation(price)) {
						while (true) {
							System.out.println("Enter product Category ");
							String category = sc.nextLine();
							if (val.nameValidation(category)) {
								bean.setMedicineName(medicineName);
								bean.setPrice(Double.parseDouble(price));
								bean.setCategory(category);
								boolean isAdded = dao.addMedicine(bean);
								if (isAdded) {
									System.out.println("Medicine is Added Successfully");
								}
								new AdminIndex().adminIndex(bean1);
							} else {
								System.out.println("Enter Valid Category");
							}
						}
					} else {
						System.out.println("Enter Valid Price");
					}
				}
			} else {
				System.out.println("Enter Valid name");
			}
		}
	}
}
