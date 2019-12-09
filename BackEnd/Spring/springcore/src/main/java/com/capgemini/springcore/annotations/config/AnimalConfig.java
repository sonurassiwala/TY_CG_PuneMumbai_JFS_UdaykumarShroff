package com.capgemini.springcore.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.capgemini.springcore.annotation.beans.Dog;
import com.capgemini.springcore.annotation.beans.Panda;

@Configuration
public class AnimalConfig {

	@Bean(name = "dog")
	public Dog getDog() {
		return new Dog();
	}
	
	@Bean(name = "panda")
	@Primary
	public Panda getPanda() {
		return new Panda();
	}
}
