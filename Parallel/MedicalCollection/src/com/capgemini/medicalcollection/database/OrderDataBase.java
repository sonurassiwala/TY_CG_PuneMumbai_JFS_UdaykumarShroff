package com.capgemini.medicalcollection.database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.medicalcollection.bean.OrderBean;

public class OrderDataBase {
	static ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
	static {
		OrderBean orderBean = new  OrderBean();
		orderList.add(orderBean);
	}
	
	public List<OrderBean> getOrderList(){
		return orderList;
	}
}
