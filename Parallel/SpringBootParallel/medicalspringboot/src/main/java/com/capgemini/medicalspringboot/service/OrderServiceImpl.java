package com.capgemini.medicalspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.OrderBean;
import com.capgemini.medicalspringboot.dao.OrderDAO;

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
