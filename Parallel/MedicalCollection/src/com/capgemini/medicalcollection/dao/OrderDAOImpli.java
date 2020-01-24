package com.capgemini.medicalcollection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.medicalcollection.bean.OrderBean;
import com.capgemini.medicalcollection.database.OrderDataBase;
import com.capgemini.medicalcollection.exception.MedicalException;

public class OrderDAOImpli implements OrderDAO {
	OrderDataBase orderDataBase = new OrderDataBase();
	List<OrderBean> orderList = orderDataBase.getOrderList();
	
	public List<OrderBean> getOrder(int uId){
		try {
			List<OrderBean> orderBeanList = new ArrayList<OrderBean>();
			for (OrderBean orderBean : orderList) {
				if(orderBean.getUserId() == uId) {
					orderBeanList.add(orderBean);
				}
			}
			return orderBeanList;
		} catch (Exception e) {
			throw new MedicalException("Unable to fetch Orders");
		}
	}


	@Override
	public boolean placeOrder(OrderBean orderBean) {
		try {
			orderBean.setOrderId(orderList.size()+300);
			boolean isPlaced = false;
			if(orderList.add(orderBean)) {
				isPlaced = true;
			}
			return isPlaced;
		} catch (Exception e) {
			throw new MedicalException("Unable to Place order");
		}
	}
}
