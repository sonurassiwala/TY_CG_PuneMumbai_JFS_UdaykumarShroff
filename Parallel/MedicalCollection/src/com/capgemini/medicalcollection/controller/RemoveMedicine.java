package com.capgemini.medicalcollection.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicalcollection.bean.MedicineBean;
import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.MedicineDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class RemoveMedicine {
	public void removeMedicine(UserBean userBean) {
		Scanner scan = new Scanner(System.in);
		MedicineDAO dao = MedicineFactory.getMedicineDAO();
		Validation val = MedicineFactory.getValidate();
		List<MedicineBean> medlist = dao.getMedicine();
		if (medlist != null) {
			for (MedicineBean medicineBean : medlist) {
				System.out.println(medicineBean);
			}
		}
		while (true) {
			System.out.println("Enter the medicine code want to Delete");
			String mCode = scan.nextLine();
			if (val.idValidation(mCode)) {
				boolean isRemoved = dao.removeMedicine(Integer.parseInt(mCode));
				if (isRemoved) {
					System.out.println("Medicine Removed Sucessfully");
				} else {
					System.out.println("Wrong Medicine Code");
				}
				new AdminIndex().adminIndex(userBean);
			}else {
				System.out.println("Enter Valid Medicine Id");
			}
		}
	}
}
