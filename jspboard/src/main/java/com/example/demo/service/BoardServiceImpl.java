package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository repository;
	
	@Override
	public void register(Board board) throws Exception {
		repository.create(board);
	}

	@Override
	public List<Board> list() throws Exception {
		return repository.list();
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		return repository.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		repository.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		repository.delete(boardNo);
	}
	
	
	
	
}