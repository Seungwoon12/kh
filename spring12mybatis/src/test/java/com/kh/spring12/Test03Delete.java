package com.kh.spring12;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class Test03Delete {

	private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-configuration.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		sqlSession = factory.openSession(true);
	}
	
	@Test
	public void test() {
		int member_no = 181;
		int count = sqlSession.delete("member.drop", member_no);
		System.out.println("count = "+ count);
		assertEquals(count, 1);
	}
	
}