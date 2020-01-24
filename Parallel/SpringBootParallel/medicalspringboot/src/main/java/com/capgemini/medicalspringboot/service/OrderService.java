package com.capgemini.medicalspringboot.service;

import java.util.List;

import com.capgemini.medicalspringboot.bean.OrderBean;


public interface OrderService {

	public boolean addOrder(OrderBean bean);
	public List<OrderBean> viewOrder(int userId);
	
}
