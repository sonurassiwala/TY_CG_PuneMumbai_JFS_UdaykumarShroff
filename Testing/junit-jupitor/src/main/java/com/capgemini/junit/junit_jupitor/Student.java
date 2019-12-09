package com.capgemini.junit.junit_jupitor;

public class Student {

	private int id;
	private String name;
	private double percentage;
	private char gender;
	
	public Student() {
		
	}
	
	public Student(String name, double percentage, char gender) {
		this.name = name;
		this.percentage = percentage;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
}
