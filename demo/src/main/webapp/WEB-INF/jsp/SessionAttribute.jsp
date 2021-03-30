<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SessionAttribute</title>
</head>
<body>
	<h1>Session 예제</h1>
	<hr><h2>Session 생성</h2>
	
	<!-- Spring Model에서 model.addAttribute와 유사한 역할을 함
	         해쉬 맵에서 키값, 밸류값 형식으로 세션을 만든다고 보면 됩니다. -->
	<%
		session.setAttribute("id", "아이디");
		session.setAttribute("pw", "비밀번호");
		
	%>
	
	<hr><h2>Session 조회</h2>
	Session ID: <%= session.getId() %>
	Session CreationTime: <%= new Date(session.getCreationTime()) %><br><br>
	
	<%
		Enumeration<String> e = session.getAttributeNames();
	
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			String value = (String)session.getAttribute(name);
			out.println("Session name: " + name + ", ");
			out.println("Session value: " + value + "<br>");
		}
	%>
	<br> Session Invalidate <% session.invalidate(); %>
</body>
</html>