package com.capgemini.medicaljdbc.dao;

import java.util.List;

import com.capgemini.medicaljdbc.bean.MedicineBean;

public interface MedicineDAO {

	public boolean addMedicine(MedicineBean bean);
	public List<MedicineBean> viewmedicine();
	public boolean removeMedicine(int uid);
	public MedicineBean getMed(int midId);
	public boolean updateMedicine(int mid, String name);
	public boolean updateMedicine(int id, double price);
	public boolean updateMedicinedescription(int medId, String catgeory);
}
