package com.capgemini.medicalspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.MedicineBean;
import com.capgemini.medicalspringboot.dao.MedicineDAO;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDAO dao;
	
	@Override
	public MedicineBean getMedicine(int medicineId) {
		return dao.getMedicine(medicineId);
	}

	@Override
	public boolean addMedicine(MedicineBean medicineBean) {
		return dao.addMedicine(medicineBean);
	}

	@Override
	public boolean deleteMedicine(int medicineId) {
		return dao.deleteMedicine(medicineId);
	}

	@Override
	public boolean updateMedicine(MedicineBean medicineBean) {
		return dao.updateMedicine(medicineBean);
	}

	@Override
	public List<MedicineBean> getAllMedicine() {
		return dao.getAllMedicine();
	}

}
