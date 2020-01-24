package com.capgemini.medicaljdbc.bean;

public class CartTableBean {
	private int cTableId;
	private double price;
	private int mId;
	private int OrderId;
	
	
	public int getcTableId() {
		return cTableId;
	}
	public void setcTableId(int cTableId) {
		this.cTableId = cTableId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	
	
}
