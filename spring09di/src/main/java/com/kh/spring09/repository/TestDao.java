package com.kh.spring09.repository;

import java.util.List;

import com.kh.spring09.entity.TestDto;

//DAO의 추상화 형태(= 대행업체)
// = 실제 객체가 아니라 요구사항을 정리해놓은 추상화 클래스
public interface TestDao {
	void insert(TestDto testDto);
	List<TestDto> select();
	boolean update(TestDto testDto);
	boolean delete(int test_no);
}