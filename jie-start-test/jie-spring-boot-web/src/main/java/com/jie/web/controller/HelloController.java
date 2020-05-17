package com.jie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//	@Autowired
//	private HelloService helloService;

	@GetMapping("/test/hello")
	public String sayHello() {
		return null;
	}
}
