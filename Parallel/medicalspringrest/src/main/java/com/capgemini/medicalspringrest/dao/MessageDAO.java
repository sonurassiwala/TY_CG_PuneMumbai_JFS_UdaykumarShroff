package com.capgemini.medicalspringrest.dao;

import java.util.List;

import com.capgemini.medicalspringrest.bean.MessageBean;

public interface MessageDAO {

	public boolean sendMessage(int userId,String message,String type);
	public List<MessageBean> getMessage();
	public boolean sendResponse(int userId,String message,String type);
	public List<MessageBean> getResponse(int userId);
	
}
