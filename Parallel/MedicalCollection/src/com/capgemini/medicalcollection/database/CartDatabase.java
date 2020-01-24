package com.capgemini.medicalcollection.database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.medicalcollection.bean.CartBean;

public class CartDatabase {

	private static List<CartBean> cartList = new ArrayList<CartBean>();
	static {
		CartBean c = new CartBean();
		cartList.add(c);
	}
	
	public List<CartBean> getCartBeans(){
		return cartList;
	}
}
