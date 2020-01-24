package com.capgemini.medicalcollection.database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.medicalcollection.bean.MedicineBean;

public class MedicineDataBase {

	static List<MedicineBean> madlist = new ArrayList<MedicineBean>();

	static {

		MedicineBean m1 = new MedicineBean(801, "Crocine", 200, "Allopathic");
		MedicineBean m2 = new MedicineBean(802, "Paracetamol", 250, "Allopathic");
		MedicineBean m3 = new MedicineBean(803, "Liv-52", 400, "Ayurveda");
		madlist.add(m1);
		madlist.add(m2);
		madlist.add(m3);

	}

	public List<MedicineBean> getMed() {

		return madlist;

	}

}
