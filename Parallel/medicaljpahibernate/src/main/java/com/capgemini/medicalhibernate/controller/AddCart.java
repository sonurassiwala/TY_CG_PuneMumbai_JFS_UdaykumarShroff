package com.capgemini.medicalhibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicalhibernate.dao.CartDAO;
import com.capgemini.medicalhibernate.dao.MedicneDAO;
import com.capgemini.medicalhibernate.dto.CartBean;
import com.capgemini.medicalhibernate.dto.MedicineBean;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;
import com.capgemini.medicaljpahibernate.validation.Validation;

public class AddCart {

	Scanner sc = new Scanner(System.in);

	public void addtoCart(UserBean userBean) {
		MedicneDAO medDAO = MedicalFactory.getMedicine();
		CartDAO cDao = MedicalFactory.getcart();
		Validation val = MedicalFactory.getValidate();
		while (true) {
			System.out.println("Enter Medicine code to Add to Cart : ");
			String mid = sc.nextLine();
			if (val.idValidation(mid)) {
				int medAvil = 0;
				List<MedicineBean> list = medDAO.getMedicine();
				for (MedicineBean medicineBean : list) {
					if (Integer.parseInt(mid) == medicineBean.getMedicineCode()) {
						medAvil++;
						CartBean cartBean = new CartBean();
						cartBean.setUserId(userBean.getUserId());
						cartBean.setMedicineCode(Integer.parseInt(mid));
						cartBean.setMedicinePrice(medicineBean.getPrice());
						boolean addCartsuccess = cDao.addCart(cartBean);
						if (addCartsuccess) {
							System.out.println("Medicine Added to Cart..!!");
						} else {
							System.out.println("Something Went Wrong..!!");
						}

					}
				}
				if (medAvil == 0) {
					System.out.println("Please Enter Correct Medicine Code..!!");
				}
				new User().choice(userBean);
			} else {
				System.out.println("Enter Valid Id");
			}
		}
	}

}
