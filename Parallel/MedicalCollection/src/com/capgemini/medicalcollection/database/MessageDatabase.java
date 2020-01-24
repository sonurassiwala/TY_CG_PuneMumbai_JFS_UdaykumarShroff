package com.capgemini.medicalcollection.database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.medicalcollection.bean.MessageBean;

public class MessageDatabase {

	public static ArrayList<MessageBean> msgList = new ArrayList<MessageBean>();
	static {
		MessageBean m = new MessageBean();
		msgList.add(m);
	}
	
	public List<MessageBean> getMessage(){
		return msgList;
	}
}
