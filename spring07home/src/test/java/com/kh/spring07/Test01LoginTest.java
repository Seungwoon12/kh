package com.kh.spring07;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.spring07.entity.MemberDto;
import com.kh.spring07.repository.MemberDao;
import com.kh.spring07.repository.MemberDaoImpl2;

//목표 : MemberDao의 login 기능이 정상적으로 작동하는지 확인
public class Test01LoginTest {

	private MemberDao memberDao;
	
	@Before
	public void before() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("web");
		dataSource.setPassword("web");
		dataSource.setMaxTotal(20);
		dataSource.setMinIdle(5);
		dataSource.setMaxIdle(5);
		dataSource.setMaxWaitMillis(3000);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		MemberDaoImpl2 memberDao = new MemberDaoImpl2();
		memberDao.setJdbcTemplate(jdbcTemplate);
		
		this.memberDao = memberDao;
	}
	
	@Test
	public void test() throws Exception {
		MemberDto memberDto = new MemberDto();
		memberDto.setMember_id("hello");
		memberDto.setMember_pw("test");
		
		boolean result = memberDao.login(memberDto);		
		System.out.println("result = "+result);
	}
	
}