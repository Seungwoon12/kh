<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	(Q) 로그인을 하게 되면 세션에 user 라는 이름으로 사용자의 아이디를 저장하도록 구현해 놨습니다.
		화면에 현재 로그인 상태인지 아닌지 true/false로 판정하여 출력하세요
 -->

<%
	session.setAttribute("user", "khacademy");
	//session.removeAttribute("user");
	String user = (String)session.getAttribute("user");
%>

<h1>로그인 상태 : <%=user != null%> </h1>
<h1>로그인 상태 : ${sessionScope.user != null}</h1>
<h1>로그인 상태 : ${user != null}</h1>
<h1>로그인 상태 : ${user ne null}</h1>
<h1>로그인 상태 : ${not empty user}</h1>
