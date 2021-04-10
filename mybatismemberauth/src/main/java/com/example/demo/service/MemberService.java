package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Member;

public interface MemberService {
	public void register(Member member) throws Exception;
	
	//public Member read(Integer userNo) throws Exception;
	
	public Integer getno() throws Exception;
	
	public Integer getno2() throws Exception;
}