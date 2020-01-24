package com.capgemini.medicalspringrest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "cart")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartBean {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	@Column
	private int userId;
	@Column
	private int medicineId;
	@Column
	private String medicineName;
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	@Column 
	private long medicinePrice;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public long getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(long medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	
	
	
}
