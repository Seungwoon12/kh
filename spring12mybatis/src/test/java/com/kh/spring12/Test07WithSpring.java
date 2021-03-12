package com.kh.spring12;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring12.entity.MemberDto;

//목표 : 스프링에 등록한 myBatis 도구를 사용하여 DB 작업을 수행
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test07WithSpring {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		System.out.println(sqlSession);
		List<MemberDto> list = sqlSession.selectList("member.list");
		System.out.println("회원 수 : "+list.size());
	}
	
}