<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>게시글 수정(edit.jsp)</h1>

<form action="edit.do" method="post">
	<input type="hidden" name="board_no" value="${boardDto.board_no}">
	말머리 : <input type="text" name="board_header" value="${boardDto.board_header}"><br><br>
	제목 : <input type="text" name="board_title" value="${boardDto.board_title}"><br><br>
	내용 : <textarea name="board_content">${boardDto.board_content}</textarea><br><br>
	<input type="submit" value="수정">		
</form>