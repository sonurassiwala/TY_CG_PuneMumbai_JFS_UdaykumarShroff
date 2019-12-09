package com.capgemini.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.bean.EmployeeInfoBean;
import com.capgemini.springrest.bean.EmployeeResponse;
import com.capgemini.springrest.service.EmployeeService;

//@Controller
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;
	
	//@ResponseBody
	@GetMapping(path = "/getEmployee",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getEmployee(int empId) {
		 EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		 EmployeeResponse response = new  EmployeeResponse();
		 if(employeeInfoBean != null) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("Employee record Found..!!");
			 response.setEmployeeInfoBean(employeeInfoBean);
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed");
			 response.setDescription("Didn't Found Employee record");
		 }
		return response;
	}//End of getEmployee()
	
	//@ResponseBody
	@PutMapping(path = "/addEmployee",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = MediaType.APPLICATION_JSON_VALUE )
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isAdded = service.addEmployee(employeeInfoBean);
		EmployeeResponse response = new EmployeeResponse();
		if(isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Added Successfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Add Employee");
		}
		return response;
	}
	
	@DeleteMapping("/deleteEmployee")
	//@ResponseBody
	public EmployeeResponse deleteEmployee(int empId) {
		boolean isDeleted = service.deleteEmployee(empId);
		EmployeeResponse response = new EmployeeResponse();
		if(isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Deleted Successfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete Employee");
		}
		return response;
	}
	
	@PostMapping(path = "/updateEmployee",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		boolean isUpdated = service.updateEmployee(employeeInfoBean);
		EmployeeResponse response = new EmployeeResponse();
		if(isUpdated) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Updated Successfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Update Employee");
		}
		return response;
	}
	
	@GetMapping(path = "/getAll",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public  EmployeeResponse getAllEmployee() {
		List<EmployeeInfoBean> employeeList = service.getAllEmployees();
		EmployeeResponse response = new EmployeeResponse();
		if(employeeList != null && !employeeList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee List Found..!!");
			response.setEmployeesList(employeeList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee List Not Found..!!");
		}
		return response;
	}
	
}
