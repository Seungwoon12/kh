package com.kh.spring07.repository;

import java.util.List;

import com.kh.spring07.entity.BoardDto;
import com.kh.spring07.entity.BoardReplyCountVO;

public interface BoardDao {
	public void write(BoardDto dto);
	public List<BoardDto> select();
	public List<BoardDto> select(String keyword);
	public List<BoardDto> select(String type, String keyword);
	public BoardDto find(int board_no);
	public boolean update(BoardDto dto);
	public boolean delete(int board_no);
	public int getSequence();
	public void writeWithPrimaryKey(BoardDto boardDto);
	public void plusReadcount(int board_no);
	public List<BoardDto> pagingList(String type, String key, int startRow, int endRow);
	public List<BoardDto> pagingList(int startRow, int endRow);
	public int getCount(String type, String key);
	public int getCount();
	public List<BoardReplyCountVO> pagingReplyCountList(int startRow, int endRow);
	public List<BoardReplyCountVO> pagingReplyCountList(String type, String key, int startRow, int endRow);
}