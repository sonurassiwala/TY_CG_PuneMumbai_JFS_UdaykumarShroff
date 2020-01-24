package com.capgemini.medicaljdbc.controller;

import java.util.List;

import com.capgemini.medicaljdbc.bean.OrderBean;
import com.capgemini.medicaljdbc.bean.UserBean;
import com.capgemini.medicaljdbc.dao.OrderDAO;
import com.capgemini.medicaljdbc.factory.MedicineFactory;

public class ViewHistory {
	public void ViewHistory(UserBean bean) {
		OrderDAO orderDAO = MedicineFactory.getOrderDao();
		List<OrderBean> list = orderDAO.getAll(bean.getUserId());
		if(!list.isEmpty()) {
			for (OrderBean orderBean : list) {
				System.out.println(orderBean);
			}
		}else {
			System.out.println("You have no Previous Order");
		}
		new UserIndex().choice(bean);
	}
}
