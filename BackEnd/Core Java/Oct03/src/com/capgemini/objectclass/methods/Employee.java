package com.capgemini.objectclass.methods;

public class Employee {

	int id;
	String name;
	double sal;
	char gender;
	public Employee(int id, String name, double sal, char gender) {
		
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", gender=" + gender + "]";
	}
	
	
	
	
	
}
