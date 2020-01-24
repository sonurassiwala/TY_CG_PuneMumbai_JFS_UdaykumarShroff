package com.capgemini.medicalhibernate.controller;

import java.util.List;

import com.capgemini.medicalhibernate.dao.OrderDAO;
import com.capgemini.medicalhibernate.dto.ItemBean;
import com.capgemini.medicalhibernate.dto.OrderBean;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;

public class ViewOrder {

	public void viewOrder(UserBean userBean) {
		
		OrderDAO odao = MedicalFactory.getOrder();
		List<OrderBean> ol = odao.viewOrder(userBean.getUserId());
		
		System.out.println("----------Order----------");
		for (OrderBean o : ol) {
			System.out.println("Order Id : " + o.getOrderId());
			System.out.println("User Id : " + o.getUid());
			System.out.println("Card No : " + o.getCardno());
			System.out.println("Price : " + o.getPrice());
//			List<ItemBean> il = odao.viewOrderItems(o.getOrderId());
//			for(ItemBean i : il) {
//				System.out.println("Medicine Id : "+i.getMedId()+" Medicine Price : "+ i.getMedPrice());
//			}
			System.out.println("-------------------------------------------");
		}
		
	}
	
}
