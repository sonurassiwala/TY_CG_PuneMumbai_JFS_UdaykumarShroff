package com.capgemini.medicalhibernate.dao;

import java.util.List;

import com.capgemini.medicalhibernate.dto.MessageBean;
import com.capgemini.medicalhibernate.dto.UserBean;

public interface MessageDAO {

	public boolean sendMessage(int userId,String message,String type);
	public List<MessageBean> getMessage(int uid);
	public boolean sendResponse(int userId,String message,String type);
	public List<MessageBean> getResponse(int uid);
	
	
}
