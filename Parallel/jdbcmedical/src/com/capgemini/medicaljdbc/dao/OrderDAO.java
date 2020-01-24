package com.capgemini.medicaljdbc.dao;

import java.util.List;

import com.capgemini.medicaljdbc.bean.OrderBean;

public interface OrderDAO {
	public boolean placeOrder(OrderBean orderBean);
	public int getMax();
	public List<OrderBean> getAll(int uid);
}
