<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 조회</title>
</head>
<body>
	<h1>쿠키 조회</h1>
	<hr>
	<%
		Cookie[] cookies = request.getCookies();
	
		if (cookies == null) {
			out.println("쿠키가 없다!");
		} else {
			for (Cookie c : cookies) {
				out.println("Cookie name: " + c.getName() + ", ");
				out.println("Cookie value: " + c.getValue() + "<br>");
			}
		}
	%>
</body>
</html>