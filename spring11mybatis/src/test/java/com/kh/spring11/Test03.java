package com.kh.spring11;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

//목표 : Test02를 @Before와 @Test로 분리
public class Test03 {
	
	private SqlSession sqlSession;
	
	@Before
	public void before() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis/mlb.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		//SqlSession을 생성할 때 자동커밋을 설정할 수 있다.
		//sqlSession = factory.openSession();//자동커밋 사용하지 않음
		//sqlSession = factory.openSession(false);//자동커밋 사용하지 않음
		sqlSession = factory.openSession(true);//자동커밋 사용함
	}
	
	@Test
	public void test() {
//		sqlSession.insert("student.add");
		
//		[1] Map을 이용한 데이터 전달
//		Map<String, Object> param = new HashMap<>();
//		param.put("student_name", "피카츄");
//		param.put("student_score", 50);
//		sqlSession.insert("student.add2", param);
		
//		[2] 객체를 이용한 데이터 전달
		Student student = new Student();
		student.setStudent_name("라이츄");
		student.setStudent_score(77);
		sqlSession.insert("student.add3", student);
	}
	
}
