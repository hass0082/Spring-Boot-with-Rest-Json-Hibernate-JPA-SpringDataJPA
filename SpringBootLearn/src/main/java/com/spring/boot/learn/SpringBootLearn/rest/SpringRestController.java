package com.spring.boot.learn.SpringBootLearn.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestController {

	
	//Injecting properties 
	
	@Value("${coach.name}")
	private String coach;
	
	
	
	@GetMapping("/map")
	public String index()
	{
		return "Spring rest";
	}
}
