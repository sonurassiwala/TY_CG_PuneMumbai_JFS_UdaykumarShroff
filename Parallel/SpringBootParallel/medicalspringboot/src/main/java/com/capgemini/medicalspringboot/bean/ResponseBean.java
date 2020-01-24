package com.capgemini.medicalspringboot.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBean {

	private int statusCode;
	private String message;
	private String description;
	private UserBean userBean;
	private MedicineBean medicineBean;
	private List<UserBean> userList;
	private List<MedicineBean> medicineList;
	private Long price;
	private CartBean cartBean;
	private List<CartBean> cartList;
	private OrderBean orderBean;
	private List<OrderBean> orderList;
	
	public OrderBean getOrderBean() {
		return orderBean;
	}
	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}
	public List<OrderBean> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderBean> orderList) {
		this.orderList = orderList;
	}
	private MessageBean messageBean;
	private List<MessageBean> messageList;
	
	
	public MessageBean getMessageBean() {
		return messageBean;
	}
	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}
	public List<MessageBean> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<MessageBean> messageList) {
		this.messageList = messageList;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public CartBean getCartBean() {
		return cartBean;
	}
	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}
	public List<CartBean> getCartList() {
		return cartList;
	}
	public void setCartList(List<CartBean> cartList) {
		this.cartList = cartList;
	}
	public List<MedicineBean> getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(List<MedicineBean> medicineList) {
		this.medicineList = medicineList;
	}
	public MedicineBean getMedicineBean() {
		return medicineBean;
	}
	public void setMedicineBean(MedicineBean medicineBean) {
		this.medicineBean = medicineBean;
	}
	public List<UserBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	
	
}
