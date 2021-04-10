package com.kh.spring13;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring13.entity.MemberDto;
import com.kh.spring13.repository.MemberDao;

@Controller
@RequestMapping("/async")
public class AsyncController {
	
	@Autowired
	private MemberDao memberDao;
	
	//만들어야 하는 기능
	//- 비동기 여부는 중요하지 않다
	//- 아이디가 중복인지를 파악해서 전송하는 페이지
	//		- 준비물 : 아이디
	//		- 결과물 : 중복인지에 대한 판정값(화면이 아니기 때문에 ViewResolver가 작동하면 안된다)
	//		- ViewResolver를 쓰지 않겠다는 설정을 해야 한다. @ResponseBody
	@RequestMapping("/idcheck")
	@ResponseBody//ViewResolver를 쓰지 않겠다는 설정
	public String idCheck(@RequestParam String member_id) throws Exception{
		MemberDto memberDto = memberDao.find(member_id);
		if(memberDto == null) {
			return "NNNNY";//사용가능
		}
		else {
			return "NNNNN";//사용불가(사용중)
		}
	}
	
	//- 닉네임이 중복인지를 파악해서 전송하는 페이지
	
	
	//- 회원목록을 구하여 전송하는 페이지
	//		- 서버에서 반환할 수 있는 값은 원칙적으로 String만 가능(통신이라서)
	//		- 변환 라이브러리를 활용한다(GSON, Jackson)
	//		- jackson-databind 라는 라이브러리를 추가하면 자동으로 JSON 형태로 반환됨
	@RequestMapping("/list")
	@ResponseBody
	public String list() throws Exception {
		List<MemberDto> list = memberDao.select();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(list);
	}
}