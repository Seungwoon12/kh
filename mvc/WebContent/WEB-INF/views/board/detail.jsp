<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>게시글 정보</h1>

<h3>번호 : ${boardDto.board_no}</h3>
<h3>작성자 : ${boardDto.board_writer}</h3>
<h3>말머리 : ${boardDto.board_header }</h3>
<h3>제목 : ${boardDto.board_title}</h3>
<h3>내용 : ${boardDto.board_content}</h3>
<h3>작성일 : ${boardDto.board_time}</h3>
<h3>조회수 : ${boardDto.board_read}</h3>