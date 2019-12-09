package com.capgemini.springrest.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

	private int statusCode;
	private String message;
	private String description;
	private EmployeeInfoBean employeeInfoBean;
	private List<EmployeeInfoBean> employeesList;
	
	public List<EmployeeInfoBean> getEmployeesList() {
		return employeesList;
	}
	public void setEmployeesList(List<EmployeeInfoBean> employeesList) {
		this.employeesList = employeesList;
	}
	public EmployeeInfoBean getEmployeeInfoBean() {
		return employeeInfoBean;
	}
	public void setEmployeeInfoBean(EmployeeInfoBean employeeInfoBean) {
		this.employeeInfoBean = employeeInfoBean;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
