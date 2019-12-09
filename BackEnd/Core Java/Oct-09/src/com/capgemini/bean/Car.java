package com.capgemini.bean;

public class Car {

	private int cost;
	private String name;
	
	public Car(int cost, String name) {	//mandatory for immutable behavior
		this.cost = cost;
		this.name = name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String getName() {
		return name;
	}
	
	
}
