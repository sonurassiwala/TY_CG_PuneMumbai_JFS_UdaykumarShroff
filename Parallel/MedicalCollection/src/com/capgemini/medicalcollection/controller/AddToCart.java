package com.capgemini.medicalcollection.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicalcollection.bean.CartBean;
import com.capgemini.medicalcollection.bean.MedicineBean;
import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.CartDAO;
import com.capgemini.medicalcollection.dao.MedicineDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;
import com.capgemini.medicalcollection.validation.Validation;

public class AddToCart {
	public void addTOCart(UserBean userBean) {
		Scanner scan = new Scanner(System.in);
		CartDAO cdao = MedicineFactory.getCartDAO();
		MedicineDAO mdao = MedicineFactory.getMedicineDAO();
		Validation val = MedicineFactory.getValidate();
		List<MedicineBean> medlist = mdao.getMedicine();
		if (medlist != null) {
			for (MedicineBean medicineBean : medlist) {
				System.out.println(medicineBean);
			}
		} else {
			System.out.println("Somthing went Wrong");
		}
		while (true) {
			System.out.println("Enter MedId to add to cart");
			String mId = scan.nextLine();
			if (val.idValidation(mId)) {

				int count = 0;
				for (MedicineBean medicineBean : medlist) {
					if (medicineBean.getMedicineCode() == Integer.parseInt(mId)) {
						count++;
						break;
					}
				}

				if (count != 0) {
					CartBean cartBean = new CartBean();
					cartBean.setCartId(0);
					cartBean.setUserId(userBean.getUserId());
					cartBean.setMedicineId(Integer.parseInt(mId));
					if (cdao.addToAdd(cartBean)) {
						System.out.println("Medicine Added SuccessFully");
						new UserIndex().userIndex(userBean);
					} else {
						System.out.println("Somthing went Wrong");
					}
				} else {
					System.out.println("Please Enter Correct Medicine");
					new UserIndex().userIndex(userBean);
				}
			} else {
				System.out.println("Enter Valid Medicine Id");
			}
		}
	}
}
