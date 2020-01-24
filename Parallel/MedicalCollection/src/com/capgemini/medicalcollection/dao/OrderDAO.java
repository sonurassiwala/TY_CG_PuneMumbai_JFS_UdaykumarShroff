package com.capgemini.medicalcollection.dao;

import java.util.List;

import com.capgemini.medicalcollection.bean.OrderBean;

public interface OrderDAO {
	
	public List<OrderBean> getOrder(int uid);
	public boolean placeOrder(OrderBean orderBean);
}
