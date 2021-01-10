<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <h1>게시글 삭제</h1>
<form action="delete.do" method="get">
	<input type="number" name="board_no" required>
	<input type="submit" value="삭제">
</form>