package com.capgemini.medicalhibernate.dao;

import java.util.List;

import com.capgemini.medicalhibernate.dto.ItemBean;
import com.capgemini.medicalhibernate.dto.OrderBean;

public interface OrderDAO {

	public boolean addOrder(OrderBean bean);
	public List<OrderBean> viewOrder(int userId);
	public OrderBean viewLastOrder();
	public boolean insertItem(int orderId);
	public List<ItemBean> viewOrderItems(int orderId);
}
