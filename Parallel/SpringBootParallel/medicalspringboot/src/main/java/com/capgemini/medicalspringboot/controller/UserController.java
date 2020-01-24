package com.capgemini.medicalspringboot.controller;

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

import com.capgemini.medicalspringboot.bean.ResponseBean;
import com.capgemini.medicalspringboot.bean.UserBean;
import com.capgemini.medicalspringboot.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(path = "/getUser",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getUser(int userId) {
		 UserBean userBean = service.getUserId(userId);
		 ResponseBean response = new  ResponseBean();
		 if(userBean != null) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("User record Found..!!");
			 response.setUserBean(userBean);
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed");
			 response.setDescription("Didn't Found User record");
		 }
		return response;
	}
	
	@PostMapping("/loginUser")
	public ResponseBean loginUser(@RequestBody UserBean userBean) {
		 UserBean userBean2 = service.loginUser(userBean.getUserEmail(), userBean.getUserPassword());
		 ResponseBean response = new  ResponseBean();
		 if(userBean2 != null) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("User login successful..!!");
			 response.setUserBean(userBean2);
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed");
			 response.setDescription("Invalid Credentials");
		 }
		return response;
	}
	
	@PutMapping(path = "/addUser",
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addUser(@RequestBody UserBean bean) {
		bean.setUserType("user");
		 boolean isAdded = service.addUser(bean);
		 ResponseBean response = new  ResponseBean();
		 if(isAdded) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("User Added successful..!!");
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed to Add user");
			 response.setDescription("Email Already Exist");
		 }
		return response;
	}
	
	@PutMapping(path = "/addAdmin",
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addAdmin(@RequestBody UserBean bean) {
		bean.setUserType("admin");
		 boolean isAdded = service.addUser(bean);
		 ResponseBean response = new  ResponseBean();
		 if(isAdded) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("Admin Added successful..!!");
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed to Add user");
			 response.setDescription("Admin Already Exist");
		 }
		return response;
	}
	
	@PostMapping(path = "/updateUser",
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean updateUser(@RequestBody UserBean userBean) {
		boolean isUpdated = service.updateUser(userBean);
		ResponseBean response = new ResponseBean();
		if(isUpdated) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Updated Successfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Update User");
		}
		return response;
		
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseBean deleteUser(int userId) {
		boolean isDeleted = service.deleteUser(userId);
		ResponseBean response = new ResponseBean();
		if(isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Deleted Successfully");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete User");
		}
		return response;
	}
	
	@GetMapping(path = "/getAllUser",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public  ResponseBean getAllUser() {
		List<UserBean> userList = service.getAllUser();
		ResponseBean response = new ResponseBean();
		if(userList != null && !userList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User List Found..!!");
			response.setUserList(userList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User List Not Found..!!");
		}
		return response;
	}
	
}
