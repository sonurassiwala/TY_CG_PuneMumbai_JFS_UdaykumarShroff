package com.capgemini.springcore.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.annotation.beans.Car;

public class CarEngineTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("carConfig.xml");
		Car car = context.getBean("mycar", Car.class);
		
		System.out.println("Model name : "+car.getModelName());
		System.out.println("Model No : "+car.getModelNo());
		System.out.println("CC: "+car.getEngine().getCC());
		System.out.println("Type : "+car.getEngine().getType());
		
	}

}
