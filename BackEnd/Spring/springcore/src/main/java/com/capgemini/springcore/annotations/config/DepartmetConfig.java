package com.capgemini.springcore.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.springcore.annotation.beans.DepartmentBean;

@Configuration
public class DepartmetConfig {

	@Bean(name="dev")
	public DepartmentBean getDepartment() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(501);
		departmentBean.setDeptName("SD");
		return departmentBean;
	}
	
	@Bean(name="test")
	public DepartmentBean getDepartment1() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(502);
		departmentBean.setDeptName("Testing");
		return departmentBean;
	}
	
	@Bean(name="hr")
	public DepartmentBean getDepartment2() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(503);
		departmentBean.setDeptName("HR");
		return departmentBean;
	}
	
	
}
