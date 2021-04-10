<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>write.jsp</h1>

<form action="write.do" method="post">

	말머리 : <input type="text" name="board_header"><br><br>
	제목 : <input type="text" name="board_title"><br><br>
	내용 : <textarea name="board_content"></textarea><br><br>
	
	<input type="submit" value="등록">
</form>