package com.spring.boot.Spring.Boot;

import org.springframework.web.bind.annotation.GetMapping;

public class Application {

	
	@GetMapping("/")
	public String sayHello()
	{
		return "HELLO";
	}
}
