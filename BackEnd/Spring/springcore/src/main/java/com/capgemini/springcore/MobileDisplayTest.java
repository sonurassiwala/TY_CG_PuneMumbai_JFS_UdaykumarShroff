package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.MobileBean;

public class MobileDisplayTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("mobileDisplay.xml");
		MobileBean mobileBean = context.getBean("mobile", MobileBean.class);
		
		System.out.println("Brand : "+mobileBean.getBrandName());
		System.out.println("Model : "+mobileBean.getModelName());
		System.out.println("Price : "+mobileBean.getPrice());
		System.out.println("Display-Size : "+mobileBean.getMobiledisplay().getDisplaySize()+" inches");
		System.out.println("Resolution : "+mobileBean.getMobiledisplay().getResolution());
		
	}

}
