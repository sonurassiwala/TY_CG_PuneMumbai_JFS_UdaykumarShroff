package com.capgemini.medicalspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringrest.bean.CartBean;
import com.capgemini.medicalspringrest.dao.CartDAO;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO dao;
	
	@Override
	public boolean addCart(int userId, int medicineId) {
		return dao.addCart(userId, medicineId);
	}

	@Override
	public List<CartBean> showCart(int userId) {
		return dao.showCart(userId);
	}

	@Override
	public boolean deleteCart(int userId) {
		return dao.deleteCart(userId);
	}

	@Override
	public long bill(int userId) {
		return dao.bill(userId);
	}

}
