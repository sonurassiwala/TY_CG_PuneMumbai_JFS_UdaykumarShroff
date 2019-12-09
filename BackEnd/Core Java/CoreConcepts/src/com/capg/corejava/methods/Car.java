package com.capg.corejava.methods;

public class Car {
	String name;
	String color;
	double price;
	
	public Car(String name, String color, double price) {
		
		this.name = name;
		this.color = color;
		this.price = price;
	}
	
	public Car(String name) {
		this.name = name;
	}

	public Car(double price) {
		this.price = price;
	}

	public Car(String name, double price) {
	}
	
	public Car(double price, String name) {
	}

	public Car() {
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", price=" + price + "]";
	}
	
	
}
