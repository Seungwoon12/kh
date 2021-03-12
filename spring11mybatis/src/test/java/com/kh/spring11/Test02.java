package com.kh.spring11;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

//목표 : myBatis 도구 모두 생성 및 구문을 실행하도록 지시(namespace=student, id=add)
public class Test02 {
	
	@Test
	public void test() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis/mlb.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		
		//session을 이용해서 (namespace=student, id=add)인 구문을 찾아 실행하도록 지시
		session.insert("student.add");
		session.commit();
	}
	
}
