package com.kh.spring12.entity;

import java.sql.Date;

public class BoardDto {
	private int board_no;
	private String board_writer;
	private String board_header;
	private String board_title;
	private String board_content;
	private int board_read;
	private Date board_time;
	public BoardDto() {
		super();
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_header() {
		return board_header;
	}
	public void setBoard_header(String board_header) {
		this.board_header = board_header;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_read() {
		return board_read;
	}
	public void setBoard_read(int board_read) {
		this.board_read = board_read;
	}
	public Date getBoard_time() {
		return board_time;
	}
	public void setBoard_time(Date board_time) {
		this.board_time = board_time;
	}
	public boolean is(String board_header) {
		return this.board_header != null && this.board_header.equals(board_header);
	}
	public String getBoard_header_string() {
		if(this.board_header == null) 
			return "";
		else
			return this.board_header;
	}
}
