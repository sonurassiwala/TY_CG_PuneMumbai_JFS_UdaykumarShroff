package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.MedicneDAO;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.validation.Validation;

public class AddMed {

	public void addMed(UserBean userBean) {

		MedicneDAO dao = MedicalFactory.getMedicine();
		Validation val = MedicalFactory.getValidate();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Medicine Name");
			String medName = sc.nextLine();
			if (val.nameValidation(medName)) {
				while (true) {
					System.out.println("Enter Price");
					String price = sc.nextLine();
					if (val.priceValidation(price)) {
						while (true) {
							System.out.println("Enter Quantity");
							String quant = sc.nextLine();
							if (val.priceValidation(quant)) {
								while (true) {
									System.out.println("Enter Medicine Category");
									String category = sc.nextLine();
									if (val.nameValidation(category)) {
										boolean added = dao.addMedicine(medName, Integer.parseInt(price),
												Integer.parseInt(quant), category);
										if (added) {
											System.out.println("Medicine Added Successfully");
										} else {
											System.out.println("Somthing wents Wrong");
										}
										new Admin().choice(userBean);
									} else {
										System.out.println("Enter Valid Category");
									}
								}
							} else {
								System.out.println("Enter Valid Quantity");
							}
						}
					} else {
						System.out.println("Enter Valid Price");
					}
				}
			} else {
				System.out.println("Enter valid Name");
			}
		}
	}

}
