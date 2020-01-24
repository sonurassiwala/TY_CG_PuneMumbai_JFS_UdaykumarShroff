package com.capgemini.medicalspringboot.service;

import java.util.List;

import com.capgemini.medicalspringboot.bean.CartBean;


public interface CartService {

	public boolean addCart(int userId, int medicineId);
	public List<CartBean> showCart(int userId);
	public boolean deleteCart(int userId);
	public long bill(int userId);
}
