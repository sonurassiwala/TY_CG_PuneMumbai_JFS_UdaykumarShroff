package com.capgemini.medicalhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartBean {

	@Id
	@Column(name = "cartId")
	private int cartId;
	@Column(name = "userId")
	private int userId;
	@Column(name = "medId")
	private int medicineCode;
	@Column(name = "medPrice")
	private int medicinePrice;
	
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
	public int getMedicineCode() {
		return medicineCode;
	}
	public void setMedicineCode(int medicineCode) {
		this.medicineCode = medicineCode;
	}
	public int getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(int medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	
	
}
