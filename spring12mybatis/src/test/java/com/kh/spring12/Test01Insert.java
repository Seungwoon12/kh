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

//목표 : 독립 테스트로 MemberDao의 insert에 해당하는 작업을 myBatis 수행 
public class Test01Insert {

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
		memberDto.setMember_id("test1212");
		memberDto.setMember_pw("test1212");
		memberDto.setMember_nick("테스트1212");
		memberDto.setMember_birth("2020-02-25");
		
		sqlSession.insert("member.join", memberDto);
	}
	
}