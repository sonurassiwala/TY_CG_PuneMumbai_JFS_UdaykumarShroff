package com.capgemini.medicalcollection.dao;

import java.util.List;

import com.capgemini.medicalcollection.bean.MessageBean;
import com.capgemini.medicalcollection.database.MessageDatabase;
import com.capgemini.medicalcollection.exception.MedicalException;

public class MessageDAOImpli implements MessageDAO {

	MessageDatabase msgDataBase = new MessageDatabase();
	List<MessageBean> msgList = msgDataBase.getMessage();

	@Override
	public boolean sendMessage(String message, int uId, String type) {
		try {
			MessageBean bean = new MessageBean();
			int msgId = msgList.size() + 700;
			bean.setMsgId(msgId);;
			bean.setUserId(uId);
			bean.setMessage(message);
			bean.setType(type);
			msgList.add(bean);

			return true;
		} catch (Exception e) {
			throw new MedicalException("Unable to send message");
		}
	}

	@Override
	public MessageBean viewResponse(int uId) {
		try {
			int check=0;
			for (MessageBean messageBean : msgList) {
				if (messageBean.getType().equals("Response") && messageBean.getUserId() == uId) {
					check++;
					System.out.println("Your Message Is " + messageBean.getMessage());
					System.out.println("-------------------------------------------");
				} 
			}if(check==0) {
				System.out.println("You Have No Previous Message");
			}
		} catch (Exception e) {
			throw new MedicalException("Unable to fetch response");
		}
		return null;
	}

	@Override
	public boolean sendResponse(String message, String type, int uId) {
		try {
			MessageBean bean = new MessageBean();
			int msgId = msgList.size() + 1001;
			bean.setMsgId(msgId);
			bean.setMessage(message);
			bean.setType(type);
			bean.setUserId(uId);
			msgList.add(bean);
			return true;
		} catch (Exception e) {
			throw new MedicalException("Unable to send response");
		}
	}

	@Override
	public MessageBean viewMessage() {
		try {
			for (MessageBean messageBean : msgList) {
				if (messageBean.getType().equals("Question")) {
					System.out.println("Message Id is " + messageBean.getMsgId());
					System.out.println("User Id is " + messageBean.getUserId());
					System.out.println("Your Message is " + messageBean.getMessage());
					System.out.println("-------------------------------------------");
				} else {
					System.out.println("You have No Previous Message");
				}
			}
		} catch (Exception e) {
			throw new MedicalException("Unable to view messages");
		}
		return null;
	}

}
