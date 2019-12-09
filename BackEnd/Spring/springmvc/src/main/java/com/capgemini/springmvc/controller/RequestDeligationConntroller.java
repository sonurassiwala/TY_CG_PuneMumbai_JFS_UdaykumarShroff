package com.capgemini.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligationConntroller {

	@GetMapping("/redirect")
	public String redirectRequest() {
		
		return "redirect:http://www.google.com";
	}
	
	@GetMapping("/forward")
	public String forwardRequest() {
		
		return "forward:/loginForm";
		
	}
	
	/*
	 * @GetMapping("/include") public String includeRequest() {
	 * 
	 * return "include:/loginForm";
	 * 
	 * }
	 */
}
