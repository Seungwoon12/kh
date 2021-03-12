package com.kh.spring07;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
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
public class Test03LoginTest {

	@Autowired
	private MemberDao memberDao;
	
	@Test
	public void test() throws Exception {
		MemberDto memberDto = new MemberDto();
		memberDto.setMember_id("admin1");
		memberDto.setMember_pw("admin2");
		
		boolean result = memberDao.login(memberDto);		
		
		//원하는 상황이 아니면 실패 처리할 수 있다.
		// = 단정문(Assert)을 이용하여 원치 않는 상황을 실패 처리할 수 있다.
		System.out.println("result = "+result);
		
		assertTrue(result);//result가 true라고 단정지어 테스트 하겠다(true이길 기대하며, 아니면 오류)
	}
	
}
