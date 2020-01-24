package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.MedicneDAO;
import com.capgemini.medicalhibernate.dto.MedicineBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.validation.Validation;
import com.mysql.jdbc.PreparedStatement.ParseInfo;

public class ChangePrice {

	public boolean chngePrc(MedicineBean medicineBean) {

		MedicneDAO dao = MedicalFactory.getMedicine();
		Validation val = MedicalFactory.getValidate();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Medicine Code whoz Price to Update");
			String code = sc.nextLine();
			if (val.idValidation(code)) {
				System.out.println("Enter Price to Update");
				String price = sc.nextLine();
				if (val.priceValidation(price)) {
					medicineBean.setMedicineCode(Integer.parseInt(code));
					medicineBean.setPrice(Integer.parseInt(price));
					boolean updatePrice = dao.changePrice(medicineBean);
					if (updatePrice) {
						System.out.println("Price Updated Successfully");
					} else {
						System.out.println("Somthing wents Wrong");
					}
					return updatePrice;

				}
			} else {
				System.out.println("Enter Valid Code");
				new ChangePrice().chngePrc(medicineBean);
			}
			return false;
		}
	}

}
