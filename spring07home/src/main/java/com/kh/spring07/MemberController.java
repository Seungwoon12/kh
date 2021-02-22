package com.kh.spring07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")//공용주소
public class MemberController {
	
	//회원가입 페이지
	@RequestMapping("/join")
	public String join() {
//		return "/WEB-INF/views/member/join.jsp";//view resolver가 없을 때
		return "member/join";//view resolver가 있을 때
	}
		
	//로그인 페이지
	@RequestMapping("/login")
	public String login() {
//		return "/WEB-INF/views/member/login.jsp";//view resolver가 없을 때
		return "member/login";//view resolver가 있을 때
	}
}