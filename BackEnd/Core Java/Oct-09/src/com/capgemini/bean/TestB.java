package com.capgemini.bean;

public class TestB {

	public static void main(String[] args) {

		Car c = new Car(20,"Benz");
		
		System.out.println("Cost is : "+c.getCost());
		System.out.println("Name is : "+c.getName());
		
		Bus b = new Bus("SkyBus",23);
		
		System.out.println(b.getName());
		System.out.println(b.getSeat());
		
		
	}

}
