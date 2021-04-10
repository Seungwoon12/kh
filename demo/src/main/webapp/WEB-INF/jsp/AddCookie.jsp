<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 테스트</title>
</head>
<body>
	<h1>쿠키 만들기</h1>
	<hr>
	Cookie cookie = new Cookie("relics", "jsp"); <br>
	cookie.setMaxAge(20); <br>
	response.addCookie(cookie); <br>
	
	<%
		Cookie cookie = new Cookie("relics", "jsp");
		cookie.setMaxAge(20);
		response.addCookie(cookie);
	%>
	
	<hr><a href="AddTimeCookie.jsp">현재 접속 시각을 Cookie로 추가</a>
</body>
</html>