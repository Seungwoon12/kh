package com.kh.spring12;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.kh.spring12.entity.MemberDto;

//목표 : 회원 목록을 조회
public class Test04List {
	
	private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		sqlSession = MybatisUtil.getFactory().openSession(true);
	}
	
	@Test
	public void test() {
		List<MemberDto> list = sqlSession.selectList("member.list");
		for(MemberDto memberDto : list) {
			System.out.println(memberDto.getMember_id());
		}
	}
	
}