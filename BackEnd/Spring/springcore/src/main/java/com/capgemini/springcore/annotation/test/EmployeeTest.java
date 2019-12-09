package com.capgemini.springcore.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.capgemini.springcore.annotation.beans.DepartmentBean;
import com.capgemini.springcore.annotation.beans.EmployeeBean;
import com.capgemini.springcore.annotations.config.EmployeeConfig;

public class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class, DepartmentBean.class);
		EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
		((AbstractApplicationContext)context).registerShutdownHook();
		
		System.out.println("Emp Id    : "+employeeBean.getEmpId());
		System.out.println("Emp Name  : "+employeeBean.getEmpName());
		System.out.println("Dept Id   : "+employeeBean.getDeptBean().getDeptId());
		System.out.println("Dept name : "+employeeBean.getDeptBean().getDeptName());
		
		
		//((AbstractApplicationContext)context).close();
	}

}
