package com.capgemini.medicalspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalspringrest.bean.CartBean;
import com.capgemini.medicalspringrest.bean.MedicineBean;
import com.capgemini.medicalspringrest.bean.ResponseBean;
import com.capgemini.medicalspringrest.bean.UserBean;
import com.capgemini.medicalspringrest.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService service;
	
	@PutMapping(path = "/addCart",
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addCart(@RequestParam int userId, @RequestParam int medicineId) {
		 boolean isAdded = service.addCart(userId, medicineId);
		 ResponseBean response = new  ResponseBean();
		 if(isAdded) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("Cart Added successful..!!");
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed");
			 response.setDescription("Unable to Add into Cart record");
		 }
		return response;
	}
	
	@GetMapping(path = "/viewCart",
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean viewCart(int userId) {
		long bill = service.bill(userId);
		List<CartBean> bean = service.showCart(userId);
		ResponseBean response = new  ResponseBean();
		 if(bean != null) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("User record Found..!!");
			 response.setPrice(bill);
			 response.setCartList(bean);
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed");
			 response.setDescription("Didn't Found User record");
		 }
		return response;
	}
	
	@DeleteMapping("/deleteCart")
	public ResponseBean deleteCart(int userId) {
		boolean isDeleted = service.deleteCart(userId);
		ResponseBean response = new ResponseBean();
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
	
	@GetMapping(path = "/totalBill", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean totalBill(@RequestParam int userId) {
		long bill = service.bill(userId);

		ResponseBean response = new ResponseBean();
		if (bill > 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setPrice(bill);
			response.setDescription("Payment Done sucessully.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setPrice(bill);
			response.setDescription("payment Failed........");
		}
		return response;
	}
	
}
