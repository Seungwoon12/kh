<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>${msg}</h2>
		<!-- 필요하다면 기존의 board controller
		         와 함께 붙여서 상호 연동도 가능함 -->
		<a href="/board/list">게시글 보기</a>
	</div>
</body>
</html>