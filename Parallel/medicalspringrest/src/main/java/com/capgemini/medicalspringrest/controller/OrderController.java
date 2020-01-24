package com.capgemini.medicalspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalspringrest.bean.OrderBean;
import com.capgemini.medicalspringrest.bean.ResponseBean;
import com.capgemini.medicalspringrest.service.CartService;
import com.capgemini.medicalspringrest.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	@Autowired
	private CartService cService;
	
	@GetMapping(path = "/viewOrder",
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean viewOrder(@RequestParam int userId) {
		List<OrderBean> bean = service.viewOrder(userId);
		
		ResponseBean response = new  ResponseBean();
		 if(bean != null) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("Your Order..!!");
			 response.setOrderList(bean);
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed");
			 response.setDescription("You didn't give any order yet...");
		 }
		return response;
	}
	
	@PutMapping(path = "/addOrder",
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addOrder(@RequestParam int userId, @RequestParam String cardno, @RequestParam String address) {
		long bill = cService.bill(userId);
		OrderBean orderBean = new OrderBean();
		orderBean.setUserId(userId);
		orderBean.setCardno(cardno);
		orderBean.setPrice(bill);
		orderBean.setAddress(address);
		boolean isAdded = service.addOrder(orderBean);
		cService.deleteCart(userId);
		ResponseBean response = new  ResponseBean();
		 if(isAdded) {
			 response.setStatusCode(201);
			 response.setMessage("Success");
			 response.setDescription("Order Added successful..!!");
		 }else {
			 response.setStatusCode(401);
			 response.setMessage("Failed");
			 response.setDescription("Unable to Add into Order record");
		 }
		return response;
	}

}
