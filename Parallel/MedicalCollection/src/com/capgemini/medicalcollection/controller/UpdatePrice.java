package com.capgemini.medicalcollection.controller;

import java.util.Scanner;

import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.MedicineDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class UpdatePrice {

	public void updatePrice(UserBean userBean) {
		Scanner scan = new Scanner(System.in);
		MedicineDAO dao = MedicineFactory.getMedicineDAO();
		Validation val = MedicineFactory.getValidate();
		while (true) {
			System.out.println("Enter MedId Want To Update");
			String mCode = scan.nextLine();
			if (val.idValidation(mCode)) {
				while (true) {
					System.out.println("Enter new Price to Update");
					String price = scan.nextLine();
					if (val.priceValidation(price)) {
						if (dao.updateMedicine(Integer.parseInt(mCode), Double.parseDouble(price))) {
							System.out.println("Medicine updated Successfully");
						}
						new AdminIndex().adminIndex(userBean);
					}else {
						System.out.println("Enter Valid Price");
					}
				}
			}else {
				System.out.println("Enter Valid Code");
			}
		}
	}
}
