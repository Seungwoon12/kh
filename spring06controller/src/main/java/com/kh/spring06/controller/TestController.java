package com.kh.spring06.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *	자바의 고질적인 문제점
 *	= 뭐만 만들려고 하면 상속을 받아야 한다.
 *	= 빠르게 완성해서 편하다는 점은 있지만, 자유도가 떨어지고 쓸데없는 코드가 많이 생긴다 
 *	= 요청을 처리해야 하는 상황은 여러 가지인데, 하나의 메소드로 모든 걸 다 하려고 하니 복잡하고 힘들다
 *	= 조금 더 유연하게 컨트롤러를 구성할 필요가 생기고 이 때 Annotation이 아주 적합한 용도로 사용된다.
 *	= 즉, implements Controller 대신 @Controller 를 사용하자!
 *	= 메타 프로그래밍(cf : 해시태그)
 */
@Controller
@RequestMapping("/test")//공용주소
public class TestController{
	
	/*		
	 	/first를 처리할 수 있는 메소드 구현 
	 	= 기존 컨트롤러 형태로 구현
	 	= 단, XML에 등록하지 않고 annotation 형태로 설정
	*/
	@RequestMapping("/first")
	public ModelAndView first(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/first.jsp");
		return mv;
	}
	
	/*		
	 	/second를 처리할 수 있는 메소드 구현 
	 	= Model 이 없는데 꼭 ModelAndView 를 써야 하는가?
	 	= request와 response를 안쓰는데 꼭 선언해야 하는가?
	 	= 안해도 된다.
	 	= Model이 없으면 반환형을 String으로 설정해서 페이지 이름만 반환해도 된다
	*/
	@RequestMapping("/second")
	public String second() {
		return "/WEB-INF/views/second.jsp";
	}
	
	
	/*		
	 	/third를 처리할 수 있는 메소드 구현 
	 	= 전달할 데이터가 있어서 Model이 필요하다
	 	= 그럼 또 ModelAndView를 써야 하나?
	 	= 써도 되고 안써도 된다
	 	= 쓸 경우는 반환형을 ModelAndView로 설정하고
	 	= 안쓸 경우는 매개변수에 Model을 선언할 수 있다
	 		= 추가할 데이터가 있다면 model에 추가하면 된다
	*/
	@RequestMapping("/third")
	public String third(Model model) {
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		model.addAttribute("dice", dice);
		return "/WEB-INF/views/third.jsp";
	}
}
