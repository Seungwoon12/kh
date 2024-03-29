package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private final static Logger log =
			LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/ajaxHome")
	public String getAjaxHome () {
		log.info("ajaxHome()");
		
		return "ajaxHome";
	}
}