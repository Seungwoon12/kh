package com.kh.spring12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring12.entity.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
//목표 : 여러 종류의 값이 있을 수도 있고, 없을 수도 있는 복잡한 검색을 구현
public class Test08ComplexSearch {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> param = new HashMap<>();
//		param.put("member_no", 3);
//		param.put("member_id", "te");
//		param.put("member_nick", "테");
//		param.put("member_birth", "2020-02-02");
//		param.put("member_auth", "일반");
//		param.put("member_point_start", 1000);
//		param.put("member_point_end", 10000);
//		param.put("member_join_start", "2021-01-01");//시간을 안썼지만 00:00:00 부터를 의미하며
//		param.put("member_join_end", "2021-01-31");//시간을 안썼지만 23:59:59 까지를 의미한다
		
		List<MemberDto> list = sqlSession.selectList("member.complexSearch", param);
		System.out.println("검색 결과 수 : " + list.size());
		for(MemberDto memberDto : list) {
			System.out.println(memberDto);
		}
	}
	
}