package com.kh.spring12;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.kh.spring12.entity.MemberDto;

public class Test02Edit {
	
	private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-configuration.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		sqlSession = factory.openSession(true);
	}
	
	@Test
	public void test() {
		MemberDto memberDto = new MemberDto();
		memberDto.setMember_nick("수정된테스트1212");
		memberDto.setMember_birth("2021-02-02");
		memberDto.setMember_no(181);
		memberDto.setMember_pw("test1212");
		
		sqlSession.update("member.edit", memberDto);
	}
	
}