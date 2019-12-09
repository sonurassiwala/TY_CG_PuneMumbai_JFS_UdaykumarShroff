package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.EmployeeBean;

public class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeBean employeeBean = (EmployeeBean) context.getBean("employeeBean1");
		EmployeeBean employeeBean2 = context.getBean("employeeBean2", EmployeeBean.class);
		
		System.out.println("Employee Id : "+employeeBean.getEmpId());
		System.out.println("Employee Name : "+employeeBean.getEmpName());
		
		System.out.println("Employee Id : "+employeeBean2.getEmpId());
		System.out.println("Employee Name : "+employeeBean2.getEmpName());
	}

}
