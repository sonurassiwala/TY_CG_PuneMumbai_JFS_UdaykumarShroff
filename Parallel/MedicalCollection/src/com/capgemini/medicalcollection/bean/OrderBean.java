package com.capgemini.medicalcollection.bean;

public class OrderBean {
	private int OrderId;
	private int userId;
	private double price;
	private String address;
	private String cardno;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	@Override
	public String toString() {
		return "OrderBean [OrderId=" + OrderId + ", userId=" + userId + ", price=" + price + ", address=" + address
				+ ", cardno=" + cardno + "]";
	}



}
