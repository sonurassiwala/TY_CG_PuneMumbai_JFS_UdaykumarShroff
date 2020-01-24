package com.capgemini.medicalcollection.controller;

import java.util.List;

import com.capgemini.medicalcollection.bean.OrderBean;
import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.dao.OrderDAO;
import com.capgemini.medicalcollection.factory.MedicineFactory;

public class ViewHistory {
	public void viewOrder(UserBean bean) {
		OrderDAO orderDAO = MedicineFactory.getOrderDAO();
		List<OrderBean> orderList = orderDAO.getOrder(bean.getUserId());
		if (orderList != null && !orderList.isEmpty()) {
			for (OrderBean orderBean : orderList) {
				System.out.println(orderBean);
			}
		} else {
			System.out.println("You have no previous order");
		}
		new UserIndex().userIndex(bean);
	}
}
