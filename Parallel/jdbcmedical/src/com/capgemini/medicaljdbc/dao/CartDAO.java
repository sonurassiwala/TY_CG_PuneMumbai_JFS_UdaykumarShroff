package com.capgemini.medicaljdbc.dao;

import java.util.List;

import com.capgemini.medicaljdbc.bean.CartBean;

public interface CartDAO {
	public boolean addTOCart(CartBean bean);
	public List<CartBean> getAll(int uid);
	public boolean removecart(int cId);
	public boolean removeAllCart(int uid);
}
