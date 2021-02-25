package com.kh.spring07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring07.repository.BoardDao;
import com.kh.spring07.repository.MemberDao;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BoardDao boardDao;
	
}