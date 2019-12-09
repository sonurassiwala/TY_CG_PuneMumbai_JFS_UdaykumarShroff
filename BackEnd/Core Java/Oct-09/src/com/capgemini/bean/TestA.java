package com.capgemini.bean;

public class TestA {

	public static void main(String[] args) {

		Student s = new Student();
		s.setId(101);
		s.setName("Suraj");
		s.setHeight(5.6);
		
		Database d = new Database();
		d.receive(s);
		
		Employee e = new Employee();
		e.setId(102);
		e.setName("Amya");
		e.setSalary(5023.65);
		e.setRole("Analyst");
		e.setDepartment("Electrical");
		
		d.receeive(e);
		
	}

}
