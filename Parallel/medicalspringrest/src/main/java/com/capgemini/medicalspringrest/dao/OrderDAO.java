package com.capgemini.medicalspringrest.dao;

import java.util.List;

import com.capgemini.medicalspringrest.bean.OrderBean;


public interface OrderDAO {

	public boolean addOrder(OrderBean bean);
	public List<OrderBean> viewOrder(int userId);
	
}
