package com.kh.spring12;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.kh.spring12.entity.MemberDto;

//목표 : 검색항목(type)과 검색어(key)를 이용하여 검색을 수행하는 테스트 구현
public class Test06Search {
	
	private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		sqlSession = MybatisUtil.getFactory().openSession(true);
	}
	
	@Test
	public void test() {
		Map<String, Object> param = new HashMap<>();
		param.put("type", "member_id");
		param.put("key", "t");
		
//		List<MemberDto> list = sqlSession.selectList("member.search", param);
		List<MemberDto> list = sqlSession.selectList("member.search2", param);
		for(MemberDto memberDto : list) {
			System.out.println(memberDto.getMember_no());
		}
	}
	
}
