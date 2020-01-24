package com.capgemini.medicalcollection.dao;

import com.capgemini.medicalcollection.bean.MessageBean;

public interface MessageDAO {
	public boolean sendMessage(String message, int uId, String type);

	public MessageBean viewResponse(int uId);

	public boolean sendResponse(String message, String type, int uId);

	public MessageBean viewMessage();

}
