<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setAttribute("id", request.getParameter("id"));
%>
<html>
<head>
<title>Session Login</title>
</head>
<body>
	<center>
		<h3>Login 되었습니다.</h3>
		<h3>
			Login ID :
			<%=(String) session.getAttribute("id")%></h3>
		<a href="/logout"> Logout </a>
	</center>
</body>
</html>