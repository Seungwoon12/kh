package com.kh.spring07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.spring07.entity.MemberDto;
import com.kh.spring07.repository.MemberDao;

@Controller
@RequestMapping("/member")//공용주소
public class MemberController {
	
//	******************* 매우 중요 ********************
//	MemberController는 작업을 수행하기 위해 MemberDao 가 필요하다.
//	등록된 MemberDao를 주입(Injection) 받도록 설정해야한다.
//	DI : Dependency Injection. 의존성 주입. 필요한 요소를 주입받아 사용한다.
//	***********************************************
	@Autowired
	private MemberDao memberDao;
	
//	회원가입 페이지
	@RequestMapping(value="/join", method=RequestMethod.GET)//Spring 3.x
//	@GetMapping("/join")//Spring 4.x
	public String join() {
//		return "/WEB-INF/views/member/join.jsp";//view resolver가 없을 때
		return "member/join";//view resolver가 있을 때
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)//Spring 3.x
//	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) throws Exception {
		memberDao.insert(memberDto);
		return "redirect:join";
	}
	
	//로그인 페이지
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
//		return "/WEB-INF/views/member/login.jsp";//view resolver가 없을 때
		return "member/login";//view resolver가 있을 때
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberDto memberDto) throws Exception {
		boolean result = memberDao.login(memberDto);
		if(result) {
			return "redirect:/";//최상위 경로(절대경로)
		}
		else {
			return "redirect:login?error";//로그인페이지(상대경로)
		}
	}
}
