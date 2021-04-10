<%@ page import="mvc.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	만약 저장소에 문자열이나 원시형 데이터가 아닌 객체가 들어있다면 어떻게 될까?
	
	EL은 추론 기능을 제공한다.
	= ${s.name}은 ${s.getName()}으로 추론되어 실행된다.
	= ${s.score}는 ${s.getScore()}으로 추론되어 실행된다.
--%>

<%
	request.setAttribute("a", 10);
	
	Student s = new Student();
	s.setName("홍길동");
	s.setScore(90);
	request.setAttribute("s", s);
%>

<h1>a = <%=request.getAttribute("a")%></h1>
<h1>a = ${requestScope.a}</h1>
<h1>a = ${a}</h1>

<h1>이름 = <%=((Student)request.getAttribute("s")).getName()%></h1> 
<h1>점수 = <%=((Student)request.getAttribute("s")).getScore()%></h1>

<h1>이름 = ${requestScope.s.getName()}</h1>
<h1>점수 = ${requestScope.s.getScore()}</h1>

<h1>이름 = ${s.getName()}</h1>
<h1>점수 = ${s.getScore()}</h1>

<h1>이름 = ${s.name}</h1>
<h1>점수 = ${s.score}</h1>