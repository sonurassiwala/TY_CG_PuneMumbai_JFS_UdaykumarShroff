package com.capgemini.medicalhibernate.dao;

import java.util.List;

import com.capgemini.medicalhibernate.dto.CartBean;

public interface CartDAO {

	public boolean addCart(CartBean cartBean);
	public List<CartBean> getCart(int id);
	public boolean removeCart(int id);
}
