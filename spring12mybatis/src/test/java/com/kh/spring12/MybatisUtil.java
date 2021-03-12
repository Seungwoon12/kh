package com.kh.spring12;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	public static SqlSessionFactory getFactory() throws IOException {
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-configuration.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		return factory;
	}
	
}