package com.capgemini.medicalcollection.dao;

import java.util.List;

import com.capgemini.medicalcollection.bean.MedicineBean;
import com.capgemini.medicalcollection.database.MedicineDataBase;
import com.capgemini.medicalcollection.exception.MedicalException;

public class MedicineDAOImpli implements MedicineDAO {
	MedicineDataBase dataBase = new MedicineDataBase();
	List<MedicineBean> medList = dataBase.getMed();

	@Override
	public List<MedicineBean> getMedicine() {
		return dataBase.getMed();
	}

	@Override
	public boolean addMedicine(MedicineBean bean) {
		try {
			int check = 0;
			bean.setMedicineCode(medList.size() + 801);
			boolean isAdded = false;
			for (MedicineBean medList : medList) {
				if (bean.getMedicineName().equals(medList.getMedicineName())) {
					check++;
				}
			}
			if (check == 0) {
				medList.add(bean);
				isAdded = true;
			} else {
				System.out.println("Medicine Already Exist");
			}
			return isAdded;
		} catch (Exception e) {
			throw new MedicalException("Unable to add Medicine");
		}
	}

	@Override
	public boolean removeMedicine(int mCode) {

		try {
			int check = 0;
			boolean isRemoved = false;
			MedicineBean bean = new MedicineBean();
			for (MedicineBean medList : medList) {
				if (mCode == medList.getMedicineCode()) {
					bean = medList;
					check++;
				}
			}
			if (check != 0) {
				medList.remove(bean);
				isRemoved = true;
			} else {
				System.out.println("Invalid Medicine Id");
			}
			return isRemoved;
		} catch (Exception e) {
			throw new MedicalException("Unable to remove medicine");
		}
	}

	@Override
	public boolean updateMedicine(int mCode, double price) {
		try {
			int check = 0;
			boolean isUpdated = false;
			MedicineBean bean = new MedicineBean();
			for (MedicineBean medList : medList) {
				if (mCode == medList.getMedicineCode()) {
					bean = medList;
					check++;
				}
			}
			if (check != 0) {
				bean.setPrice(price);
				isUpdated = true;
			} else {
				System.out.println("Inalid Medicine ID");
			}
			return isUpdated;
		} catch (Exception e) {
			throw new MedicalException("Unable to update price");
		}
	}
}
