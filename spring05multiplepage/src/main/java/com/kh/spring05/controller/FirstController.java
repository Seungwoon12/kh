package com.kh.spring05.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FirstController implements Controller{

	@Override
	public ModelAndView handleRequest(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//계산 코드
		
		//포워드 코드
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/first.jsp");
		return mv;
	}

}