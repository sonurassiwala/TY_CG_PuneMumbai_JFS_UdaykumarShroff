package com.capgemini.springcore.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("My Post Processor");
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("messageBean2");
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		
		System.out.println("Message from XML : "+propertyValues.getPropertyValue("message").getValue());
		
		propertyValues.addPropertyValue("message", "Welcome To Spring-5");
		
	}

}
