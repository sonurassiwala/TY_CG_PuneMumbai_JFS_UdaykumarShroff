package com.capgemini.array.genric;

public class TestI {

	public static void main(String[] args) {

		Employee[] emp = new Employee[4];
		
		Employee e1 = new Employee(1, "Amit", 9826.1234);
		Employee e2 = new Employee(2, "Suraj", 7821.8945);
		Employee e3 = new Employee(3, "Rushi", 7412.4252);
		Employee e4 = new Employee(4, "Niru", 8545.5472);
		
		emp[0] = e1;
		emp[1] = e2;
		emp[2] = e3;
		emp[3] = e4;
		
		receive(emp);
		
	}

	static void receive(Employee[] ar) {
		
		for( Employee k : ar) {
			
			System.out.print(" "+k.eid);
			System.out.print(" "+k.ename);
			System.out.println(" "+k.salary);
			System.out.println("****************************");
			
		}
		
	}
}
