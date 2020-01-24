package com.capgemini.medicalhibernate.controller;

import com.capgemini.medicalhibernate.dao.OrderDAO;
import com.capgemini.medicalhibernate.dto.OrderBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;

public class AddOrder {

	public void addOrder(int id, String cardno, int price, String cvv) {
		
		OrderDAO odao = MedicalFactory.getOrder();
		OrderBean bean = new OrderBean();
		
		bean.setUid(id);
		bean.setCardno(cardno);
		bean.setPrice(price);
		
		if(odao.addOrder(bean)) {
			System.out.println("order Placed SuccessFull");
			//OrderBean order = odao.viewLastOrder();
			//boolean item = odao.insertItem(order.getOrderId());
		}else {
			System.out.println("Unable To Place Order");
		}
	}
	
}
