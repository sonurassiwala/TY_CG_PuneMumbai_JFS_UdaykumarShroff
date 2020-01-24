package com.capgemini.medicalspringboot.dao;

import java.util.List;

import com.capgemini.medicalspringboot.bean.OrderBean;

public interface OrderDAO {

	public boolean addOrder(OrderBean bean);
	public List<OrderBean> viewOrder(int userId);
	
}
