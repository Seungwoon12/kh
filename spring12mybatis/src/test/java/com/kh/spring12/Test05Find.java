package com.kh.spring12;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.kh.spring12.entity.MemberDto;

//목표 : 번호를 이용해서 회원 1명을 조회
public class Test05Find {
	
	private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		sqlSession = MybatisUtil.getFactory().openSession(true);
	}
	
	@Test
	public void test() {
		int member_no = 11111;
		MemberDto memberDto = sqlSession.selectOne("member.find", member_no);
		System.out.println(memberDto);//있으면 객체정보, 없으면 null
	}
}
