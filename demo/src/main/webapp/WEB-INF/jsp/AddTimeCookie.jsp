<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간 쿠키 저장</title>
</head>
<body>
	<h1>현재 시간을 Cookie로 저장한다.</h1>
	<hr>
	Calendar day = Calendar.getInstance(); <br>
	String now = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH) + 1); <br>
	now += "-" + day.get(Calendar.DAY_OF_MONTH); <br>
	
	Cookie cookie = new Cookie("lastconnect", now); <br>
	cookie.setMaxAge(10); <br>
	response.addCookie(cookie); <br>
	
	<%
		Calendar day = Calendar.getInstance();
		String now = day.get(Calendar.YEAR) + "-" + (day.get(Calendar.MONTH) + 1);
		now += "-" + day.get(Calendar.DAY_OF_MONTH);
		
		Cookie cookie = new Cookie("lastconnect", now);
		// 살아있는 시간 30초
		cookie.setMaxAge(30);
		response.addCookie(cookie);
	%>
	<hr><a href="cookieLookUp">쿠키 조회하기</a>
</body>
</html>