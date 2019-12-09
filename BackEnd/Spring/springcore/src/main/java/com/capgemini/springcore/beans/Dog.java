package com.capgemini.springcore.beans;

import com.capgemini.springcore.interfaces.Animal;

public class Dog implements Animal {

	@Override
	public void eat() {
		System.out.println("Eating Pedigree");
	}

	@Override
	public void speak() {
		System.out.println("Bhow bhow...!!!!");
	}

	@Override
	public void walk() {
		System.out.println("Dog is running...");
	}

}
