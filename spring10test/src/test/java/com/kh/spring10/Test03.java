package com.kh.spring10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//목표 : Spring 환경을 연동시킨 테스트 수행
// = 연동시킬것이라는 사실을 명시적으로 선언해야 한다
// 	= @RunWith를 이용하여 연동시킬 환경을 정의
// = 설정파일이 어디에 있는지도 알려줘야 한다(설정파일은 위치가 고정이 아니라 자유롭게 설정이 가능하므로)
//		= @ContextConfiguration 사용
//		= root-context.xml과 servlet-context.xml과 연동해야 함을 알려준다
//		= Spring에서 파일을 찾을 때 사용할 수 있는 경로는 2가지가 존재
//			= file: 로 시작하면 프로젝트부터 시작하는 경로를 의미
//			= classpath: 로 시작하면 source folder 부터의 경로를 의미(webapp은 탐색이 불가능)
// = 연동 테스트 시 운영설정파일인 web.xml이 없어서 오류가 발생한다.
//		= @WebAppConfiguration 이라는 설정으로 가짜 web.xml을 만들어 쓸 것을 지시한다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test03 {

	//연동이 되어 있다면 주입도 가능하다
	// = DAO 등 내가 테스트 하고 싶은 등록된 객체를 Autowired를 통해 주입하여 사용할 수 있다.
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void test() {
		System.out.println(ctx);
	}
	
}