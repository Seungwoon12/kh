package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JSPLoginController {
	private static final Logger log = LoggerFactory.getLogger(JSPLoginController.class);

	@GetMapping("/login")
	public String getLogin() {
		log.info("getLogin()");

		return "session/SessionLogin";
	}

	@PostMapping("/login2")
	public String getLogin2() {
		log.info("getLogin()");

		return "session/SessionLogin2";
	}

	@GetMapping("/logout")
	public String getSessionLogout() {
		log.info("getSessionLogout()");

		return "session/SessionLogout";
	}
}