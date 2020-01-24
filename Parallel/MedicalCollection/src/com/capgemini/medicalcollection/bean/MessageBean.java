package com.capgemini.medicalcollection.bean;

public class MessageBean {

	private int msgId;
	private int userId;
	private String message;
	private String type;
	
	
	
	public MessageBean() {
		super();
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MessageBean [msgId=" + msgId + ", userId=" + userId + ", message=" + message + ", type=" + type + "]";
	}

	
	
}
