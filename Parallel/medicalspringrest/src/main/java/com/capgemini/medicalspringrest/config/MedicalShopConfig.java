package com.capgemini.medicalspringrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class MedicalShopConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEMF()
	{
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("Test");
		
		return factoryBean;
	}// End of getEMF()
	
}//End of Configuration
