package com.kh.spring05.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ThirdController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/third.jsp");
		mv.addObject("dice", dice);
		return mv;
	}

}