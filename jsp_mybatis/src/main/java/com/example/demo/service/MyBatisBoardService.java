package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.MyBatisBoard;

public interface MyBatisBoardService {
	public void register(MyBatisBoard board) throws Exception;
	
	public List<MyBatisBoard> list() throws Exception;
	
	public MyBatisBoard read(Integer board_no) throws Exception;
	
	public void modify(MyBatisBoard board) throws Exception;
	
	public void remove(Integer board_no) throws Exception;
}