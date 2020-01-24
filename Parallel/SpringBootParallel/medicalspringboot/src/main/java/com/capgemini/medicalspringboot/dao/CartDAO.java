package com.capgemini.medicalspringboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringboot.bean.CartBean;


@Repository("CartDAO")
public interface CartDAO {

	public boolean addCart(int userId, int medicineId);
	public List<CartBean> showCart(int userId);
	public boolean deleteCart(int userId);
	public long bill(int userId);
}
