package com.demo.cookie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping("/hello")
	public String sayHello(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " = " + cookie.getValue());
		}
		return "Hello World!";
	}

	@GetMapping("/cookie")
	public String sayHello(HttpServletResponse response) {
		Cookie age = new Cookie("age", "38");
		age.setDomain("zhang.com");
		response.addCookie(age);
		return "add cookie success";
	}

	@GetMapping("/addUser")
	public String addUser(@RequestParam("userName") String userName, HttpSession session) {
		session.setAttribute("user", userName);
		return "Success";
	}

	@GetMapping("/getUser")
	public String getUser(HttpSession session) {
		String res = String.format("AppName: %s,  SessionId: %s,  User: %s", appName, session.getId(), session.getAttribute("user").toString());
		return res;
	}
}
