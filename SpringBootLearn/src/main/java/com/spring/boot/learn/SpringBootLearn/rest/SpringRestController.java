package com.spring.boot.learn.SpringBootLearn.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestController {

	@GetMapping("/map")
	public String index()
	{
		return "Spring rest";
	}
}
