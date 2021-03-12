package com.kh.spring07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring07.entity.MemberDto;
import com.kh.spring07.repository.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test02LoginTest {

	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void test() throws Exception {
		MemberDto memberDto = new MemberDto();
		memberDto.setMember_id("admin");
		memberDto.setMember_pw("admin");
		
		boolean result = memberDao.login(memberDto);		
		System.out.println("result = "+result);
	}
	
}
