package com.capgemini.medicalspringboot.service;

import java.util.List;

import com.capgemini.medicalspringboot.bean.MessageBean;


public interface MessageService {

	public boolean sendMessage(int userId,String message,String type);
	public List<MessageBean> getMessage();
	public boolean sendResponse(int userId,String message,String type);
	public List<MessageBean> getResponse(int userId);
	
}
