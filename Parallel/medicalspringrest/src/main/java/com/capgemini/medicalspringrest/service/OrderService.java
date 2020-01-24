package com.capgemini.medicalspringrest.service;

import java.util.List;

import com.capgemini.medicalspringrest.bean.OrderBean;

public interface OrderService {

	public boolean addOrder(OrderBean bean);
	public List<OrderBean> viewOrder(int userId);
	
}
