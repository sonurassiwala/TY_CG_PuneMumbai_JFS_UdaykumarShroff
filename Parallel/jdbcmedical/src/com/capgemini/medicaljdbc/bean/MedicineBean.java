package com.capgemini.medicaljdbc.bean;

public class MedicineBean 
{
	private int medicine_code;
	private String medicine_name;
	private double price;
	private String product_category;
	public int getMedicine_code() {
		return medicine_code;
	}
	public void setMedicine_code(int medicine_code) {
		this.medicine_code = medicine_code;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	@Override
	public String toString() {
		return " medicine_code  =  " + medicine_code + ", medicine_name =  " + medicine_name + ", price =  " + price
				+ ", product_category= " + product_category  ;
	}
	
	
}
