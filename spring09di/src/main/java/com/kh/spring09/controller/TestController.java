package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.spring09.repository.TestDao;

@Controller
public class TestController {

	//아래와 같이 연결 설정을 하면 TestDao의 자식클래스 중 등록된 것을 주입하여 사용하겠다는 뜻
	@Autowired
	private TestDao testDao;
	
}