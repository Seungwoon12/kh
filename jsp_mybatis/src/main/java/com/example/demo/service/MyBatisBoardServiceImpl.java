package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyBatisBoard;
import com.example.demo.repository.MyBatisBoardRepository;

@Service
public class MyBatisBoardServiceImpl implements MyBatisBoardService {
	
	@Autowired
	private MyBatisBoardRepository repository;

	@Override
	public void register(MyBatisBoard board) throws Exception {
		// TODO Auto-generated method stub
		repository.create(board);
	}

	@Override
	public List<MyBatisBoard> list() throws Exception {
		// TODO Auto-generated method stub
		return repository.list();
	}

	@Override
	public MyBatisBoard read(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return repository.read(boardNo);
	}

	@Override
	public void modify(MyBatisBoard board) throws Exception {
		// TODO Auto-generated method stub
		repository.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		repository.delete(boardNo);
	}
	
}