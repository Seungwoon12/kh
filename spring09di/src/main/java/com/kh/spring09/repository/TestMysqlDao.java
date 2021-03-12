package com.kh.spring09.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.spring09.entity.TestDto;

@Repository
public class TestMysqlDao implements TestDao{

	@Override
	public void insert(TestDto testDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestDto> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(TestDto testDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int test_no) {
		// TODO Auto-generated method stub
		return false;
	}

}