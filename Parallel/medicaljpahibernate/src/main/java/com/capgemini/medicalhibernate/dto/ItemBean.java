package com.capgemini.medicalhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemBean {
	@Id
	@Column(name = "cartId")
	private int cartId;
	@Column(name = "userId")
	private int userId;
	@Column(name = "medId")
	private int medId;
	@Column(name = "medPrice")
	private int medPrice;
	@Column(name = "orderId")
	private int orderId;
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
	public int getMedId() {
		return medId;
	}
	public void setMedId(int medId) {
		this.medId = medId;
	}
	public int getMedPrice() {
		return medPrice;
	}
	public void setMedPrice(int medPrice) {
		this.medPrice = medPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}  
	
	
}
