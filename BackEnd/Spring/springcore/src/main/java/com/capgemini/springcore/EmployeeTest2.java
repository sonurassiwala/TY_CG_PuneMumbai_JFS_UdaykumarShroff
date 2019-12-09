package com.capgemini.springcore;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.EmployeeBean;

public class EmployeeTest2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employeeConfig.xml");
		EmployeeBean emp1 = context.getBean("employee", EmployeeBean.class);
		
		System.out.println("Enter Employee Id : ");
		int empid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Employee Name : ");
		String name = sc.nextLine();
		
		emp1.setEmpId(empid);
		emp1.setEmpName(name);
		
		EmployeeBean emp2 = context.getBean("employee", EmployeeBean.class);
		
		System.out.println("Enter Employee Id : ");
		int empid2 = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Employee Name : ");
		String name2 = sc.nextLine();
		
		emp2.setEmpId(empid2);
		emp2.setEmpName(name2);
		
		System.out.println("Emp1 ID : "+emp1.getEmpId());
		System.out.println("Emp1 Name : "+emp1.getEmpName());
		
		System.out.println("Emp2 Id : "+emp2.getEmpId());
		System.out.println("Emp2 Name : "+emp2.getEmpName());
		
	}

}
