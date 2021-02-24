package com.kh.spring10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test02 {
	
	@Test
	public void test() {
		System.out.println("테스트 코드");
	}
	
	@Before
	public void before() {
		System.out.println("사전준비코드!");
	}
	
	@After
	public void after() {
		System.out.println("마무리 코드!");
	}
	
}
