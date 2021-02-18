package com.kh.spring04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/hello.jsp");//뒤에 올 페이지(view 정보)
		mv.addObject("name", "KH정보교육원");//페이지에 전달할 데이터(model 정보)
		return mv;
	}

}