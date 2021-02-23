package com.kh.spring08;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParamController {
	
	//입력페이지는 주소 한 개를 GET/POST로 나누어서 사용한다
	//= GET 방식으로 접근하면 입력페이지로 안내
	//= POST 방식으로 접근하면 데이터를 받아서 추가 작업을 수행
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET) //GET방식
	public String test1() {
//		return "/WEB-INF/views/param/test1.jsp";//view resolver 없을 때
		return "param/test1";//view resolver 있을 때
	}
	
//	스프링에서는 파라미터를 수신하는 방식이 여러 가지가 있다.
//	(1) 기존처럼 HttpServletRequest 를 사용하는 방식
//	(2) @RequestParam 을 사용하는 방식
//	(3) @ModelAttribute 를 사용하는 방식
	
//	(1) 번 방식
//	@RequestMapping(value = "/test1", method = RequestMethod.POST) //POST방식
	public String test1(HttpServletRequest req) {
		String name = req.getParameter("name");
		int score = Integer.parseInt(req.getParameter("score"));
		
		System.out.println("name = " + name);
		System.out.println("score = " + score);
		
		return "redirect:test1";//test1 주소로 redirect 하라!(GET방식)
	}
	
//	(2) 번 방식
//	= req.getParameter()를 안써도 받아주겠다!
//	= 매개변수에 형태와 이름을 맞추어 변수를 작성하면 스프링에서 자동으로 수신하여 대입해준다.
//	= 그냥 변수만 적으면 용도가 혼동될 수 있으므로 명시적으로 annotation을 표시하겠다.
//	= @RequestParam
	
//	@RequestMapping(value="/test1" , method=RequestMethod.POST)
	public String test1(@RequestParam String name, @RequestParam int score) {
		System.out.println("name = " + name);
		System.out.println("score = " + score);
		
		return "redirect:test1";
	}
	
//	(3) 번 방식
//	= 클래스를 만들고 해당 클래스의 변수에 알맞게 수신하도록 부탁
//	= @ModelAttribute
	@RequestMapping(value = "/test1" , method = RequestMethod.POST)
	public String test1(@ModelAttribute Student student) {
		System.out.println("이름 = "+student.getName());
		System.out.println("점수 = "+student.getScore());
		
		return "redirect:test1";
	}
}