package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/user")
public class MyBatisMemberController {
	
	private static final Logger log =
			LoggerFactory.getLogger(MyBatisMemberController.class);
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/register")
	public void registerForm(Member member, Model model) 
			throws Exception {
		
		log.info("registerForm()");
	}
	
	@PostMapping("/register")
	public String register(Member member, Model model) throws Exception {
		service.register(member);
		
		model.addAttribute("msg", "등록이 성공적으로 완료되었습니다!");
		
		return "user/success";
	}
}