package com.capgemini.springcore.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.capgemini.springcore.annotation.beans.Pet;

@Import(AnimalConfig.class)
@Configuration
public class PetConfig {

	@Bean
	public Pet getPet() {
		Pet myPet = new Pet();
		myPet.setName("Rocky");
		return myPet;
	}
	
}
