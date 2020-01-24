package com.capgemini.medicalhibernate.controller;

import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.MedicneDAO;
import com.capgemini.medicalhibernate.dto.MedicineBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.validation.Validation;

public class RemoveMed {

	public boolean removeMed(MedicineBean medicineBean) {

		MedicneDAO dao = MedicalFactory.getMedicine();
		Validation val = MedicalFactory.getValidate();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Medicie Code to remove");
			String id = sc.nextLine();
			if (val.idValidation(id)) {
				medicineBean.setMedicineCode(Integer.parseInt(id));
				boolean deleted = dao.removeMed(medicineBean);
				if (deleted) {
					System.out.println("Removed Successfully");
				} else {
					System.out.println("Somthing wents Wrong");
				}
				return deleted;

			} else {
				System.out.println("Enter Valid Id");
				new RemoveMed().removeMed(medicineBean);
			}
			return false;
		}
	}
}
