package com.capgemini.springcore.annotation.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeBean {

	private int empId;
	private String empName;
	@Autowired(required = false)
	@Qualifier("hr")
	private DepartmentBean deptBean;
	
	public DepartmentBean getDeptBean() {
		return deptBean;
	}
	public void setDeptBean(DepartmentBean deptBean) {
		this.deptBean = deptBean;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	//Bean life-cycle method
	@PostConstruct
	public void init() {
		System.out.println("Init Phase..!!");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy Phase..!!");
	}
}
