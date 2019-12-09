package com.capgemini.springcore.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.annotation.beans.MessageBean;
import com.capgemini.springcore.annotations.config.MessageConfig;

public class MessageTest {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
		MessageBean messageBean = context.getBean(MessageBean.class);
		System.out.println(messageBean.getMessage());
		
		MessageBean messageBean2 = context.getBean(MessageBean.class);
		System.out.println("Message2 : "+messageBean2.getMessage());
		
		messageBean2.setMessage("It's a New Message of beans");
		System.out.println("Message1 : "+messageBean.getMessage());
		System.out.println("Message2 : "+messageBean2.getMessage());
		
		
	}

}
