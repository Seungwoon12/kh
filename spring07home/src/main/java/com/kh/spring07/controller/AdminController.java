package com.kh.spring07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.spring07.repository.MemberDao;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MemberDao memberDao;
	
//	@RequestMapping(value="/home", method=RequestMethod.GET)
	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}
	
}
