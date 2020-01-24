package com.capgemini.medicalcollection.dao;

import java.util.List;

import com.capgemini.medicalcollection.bean.CartBean;

public interface CartDAO {
	public List<CartBean> getCart(int uid);
	public boolean removecart(int cartItem);
	boolean addToAdd(CartBean cartBean);
	boolean removeAllCart(int uId);
	
}
