package com.capgemini.bean;

public class Database {

	void receive(Student s) {
		System.out.println("********Student**********");
		System.out.println("Name is : "+s.getId());
		System.out.println("Name is : "+s.getName());
		System.out.println("Name is : "+s.getHeight());
	}
	
	void receeive(Employee e) {
		System.out.println("********Employee**********");
		System.out.println("Name is : "+e.getId());
		System.out.println("Name is : "+e.getName());
		System.out.println("Name is : "+e.getSalary());
		System.out.println("Name is : "+e.getRole());
		System.out.println("Name is : "+e.getDepartment());
	}
}
