package com.capgemini.medicalspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringrest.bean.OrderBean;
import com.capgemini.medicalspringrest.dao.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO dao;
	
	@Override
	public boolean addOrder(OrderBean bean) {
		return dao.addOrder(bean);
	}

	@Override
	public List<OrderBean> viewOrder(int userId) {
		return dao.viewOrder(userId);
	}

}
