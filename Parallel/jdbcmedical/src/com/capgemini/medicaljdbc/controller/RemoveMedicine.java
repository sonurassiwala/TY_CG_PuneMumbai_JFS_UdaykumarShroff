package com.capgemini.medicaljdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.medicaljdbc.bean.MedicineBean;
import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.MedicineDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class RemoveMedicine {

	public void removeMedicine(UserBean bean) {
		Scanner scan = new Scanner(System.in);
		MedicineDAO dao = MedicineFactory.getMedicineDAO();
		List<MedicineBean> list = dao.viewmedicine();
		if (list != null) {
			for (MedicineBean medicineBean : list) {
				System.out.println(medicineBean);
			}
			System.out.println("Enter the medicine code want to Delete");
			int mCode = Integer.parseInt(scan.nextLine());
			boolean isRemoved = dao.removeMedicine(mCode);
			if(isRemoved) {
				System.out.println("Medicine Removed Sucessfully");
			}
			else {
				System.out.println("Wrong Medicine Code");
			}
			new AdminIndex().choice(bean);
		}
	}
}
