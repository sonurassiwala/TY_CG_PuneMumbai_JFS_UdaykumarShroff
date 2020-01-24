package com.capgemini.medicalhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class MedicineBean {

	@Id
	@Column(name = "medicineCode")
	private int medicineCode;
	@Column(name = "medicineName")
	private String medicineName;
	@Column(name = "price")
	private int price;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "category")
	private String category;
	
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
