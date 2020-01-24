package com.capgemini.medicalspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.MessageBean;
import com.capgemini.medicalspringboot.dao.MessageDAO;

@Service
public class MessgaeServiceImpl implements MessageService {

	@Autowired
	private MessageDAO dao;
	
	@Override
	public boolean sendMessage(int userId, String message, String type) {
		return dao.sendMessage(userId, message, type);
	}

	@Override
	public List<MessageBean> getMessage() {
		return dao.getMessage();
	}

	@Override
	public boolean sendResponse(int userId, String message, String type) {
		return dao.sendResponse(userId, message, type);
	}

	@Override
	public List<MessageBean> getResponse(int userId) {
		return dao.getResponse(userId);
	}

}
