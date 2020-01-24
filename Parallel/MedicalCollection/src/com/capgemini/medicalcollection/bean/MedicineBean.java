package com.capgemini.medicalcollection.bean;

public class MedicineBean {
	private int medicineCode;
	private String medicineName;
	private double price;
	private String category;
	
	
	
	public MedicineBean() {
		super();
	}
	@Override
	public String toString() {
		return "MedicineBean [medicineCode=" + medicineCode + ", medicineName=" + medicineName + ", price=" + price
				+ ", category=" + category + "]";
	}
	public MedicineBean(int medicineCode, String medicineName, double price, String category) {
		super();
		this.medicineCode = medicineCode;
		this.medicineName = medicineName;
		this.price = price;
		this.category = category;
	}
	public int getMedicineCode() {
		return medicineCode;
	}
	public void setMedicineCode(int medicineCode) {
		this.medicineCode = medicineCode;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	

}
