package com.capgemini.medicalhibernate.dao;

import java.util.List;

import com.capgemini.medicalhibernate.dto.MedicineBean;
import com.capgemini.medicalhibernate.dto.UserBean;

public interface MedicneDAO {

	public List<MedicineBean> getMedicine();
	public boolean addMedicine(String name, int price, int quantity, String category);
	public boolean changePrice(MedicineBean medicineBean);
	public boolean removeMed(MedicineBean medicineBean);
}
