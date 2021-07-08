package com.example.demo.entity;

import java.time.LocalDateTime;

public class MyBatisBoard {
	private int board_no;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime reg_date;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDateTime getReg_date() {
		return reg_date;
	}
	public void setReg_date(LocalDateTime reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "MyBatisBoard [board_no=" + board_no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", reg_date=" + reg_date + "]";
	}
	
}
