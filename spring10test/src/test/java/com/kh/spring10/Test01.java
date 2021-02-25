package com.kh.spring10;

import org.junit.Test;

public class Test01 {
	
	//단위 테스트 메소드
	//규칙 : 접근제한 public , 반환형 void , 이름은 자유 , 매개변수가 없도록 메소드를 만들어야 한다
	//= 만들어진 메소드에 테스트용임을 표시하도록 @Test를 부여한다.
	@Test
	public void hello() {
		System.out.println("Hello Spring Test!");
	}
	
}