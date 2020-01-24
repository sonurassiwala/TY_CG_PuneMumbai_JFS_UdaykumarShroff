package com.capgemini.medicalhibernate.controller;

import com.capgemini.medicalhibernate.dao.MedicneDAO;
import com.capgemini.medicalhibernate.factory.MedicalFactory;

public class ViewMedicine {

	public void viewMed() {
		
		MedicneDAO dao = MedicalFactory.getMedicine();
		dao.getMedicine();
	}
	
}
