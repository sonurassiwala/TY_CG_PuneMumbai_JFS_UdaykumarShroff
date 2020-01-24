package com.capgemini.medicalcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.medicalcollection.bean.CartBean;
import com.capgemini.medicalcollection.database.CartDatabase;
import com.capgemini.medicalcollection.exception.MedicalException;

public class CartDAOImpli implements CartDAO {
	public List<CartBean> cartList = new CartDatabase().getCartBeans();
	CartDatabase cartDatabase = new CartDatabase();

	@Override
	public List<CartBean> getCart(int uid) {
		List<CartBean> list;
		try {
			list = new ArrayList<CartBean>();
			for (CartBean cartBean : cartList) {
				if (cartBean.getUserId() == uid) {
					list.add(cartBean);
				}
			}
		} catch (Exception e) {
			throw new MedicalException("Unable to fetch from cart");
		}
		return list;
	}

	@Override
	public boolean removecart(int cartItem) {
		try {
			CartBean cart = null;
			boolean isDeleted = false;
			for (CartBean cartBean : cartList) {
				if (cartItem == cartBean.getCartId()) {
					cart = new CartBean();
					cart = cartBean;
					break;
				}
			}
			if (cart != null) {
				cartList.remove(cart);
				isDeleted = true;
			}
			return isDeleted;
		} catch (Exception e) {
			throw new MedicalException("Unable to delete from cart");
		}
	}

	@Override
	public boolean addToAdd(CartBean bean) {
		try {
			System.out.println("Welcome to addTo");
			bean.setCartId(cartList.size() + 900);
			boolean isAdded = false;
				if(cartList.add(bean)) {
				isAdded = true;
			}
			return isAdded;
		} catch (Exception e) {
			throw new MedicalException("Unable to add into cart");
		}
	}

	@Override
	public boolean removeAllCart(int uId) {
		try {
			CartBean cart = null;
			boolean isDeleted = false;
			cartList.removeIf((bean) -> bean.getUserId() == uId);
			isDeleted = true;
			return isDeleted;
		} catch (Exception e) {
			throw new MedicalException("Unable to remove from cart");
		}
	}
}
