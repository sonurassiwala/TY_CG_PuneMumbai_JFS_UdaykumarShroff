package com.capgemini.springcore.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.capgemini.springcore.annotation.beans.EmployeeBean;

@Import(DepartmetConfig.class)

@Configuration
public class EmployeeConfig {

	@Bean
	public EmployeeBean getEmployee() {
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setEmpId(101);
		employeeBean.setEmpName("Jagnish");
		return employeeBean;
	}
}
