package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	private final static Logger log =
			LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	MemberRepository repository;
	
	@Autowired
	MemberService service;
	
	@Override
	public void register(Member member) throws Exception {
		// TODO Auto-generated method stub
		repository.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setUserNo(service.getno2());
		memberAuth.setAuth("ROLE_USER");
		
		repository.createAuth(memberAuth);
	}

	@Override
	public Integer getno() throws Exception {
		// TODO Auto-generated method stub
		return repository.getno();
	}

	@Override
	public Integer getno2() throws Exception {
		// TODO Auto-generated method stub
		return repository.getno2();
	}

	
}