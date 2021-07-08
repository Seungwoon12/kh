package com.khfinal2.cluster.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	
	@GetMapping("/home")
	public String index(Locale locale, Model model) {
		log.info("index()");
		
		Date date = new Date();
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "index";
		
	}

}
