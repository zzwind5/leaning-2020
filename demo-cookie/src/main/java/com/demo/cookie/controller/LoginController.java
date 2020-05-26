package com.demo.cookie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam("userName") String userName, HttpSession session) {
		session.setAttribute("user", userName);
		return "Success";
	}
}
