<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL에서는 파라미터 외의 여러 저장소를 각각 접근할 수 있는 내장객체가 존재
	= 저장소 이름은 생략이 가능
	= 이름이 충돌날 경우에는 저장소 이름을 적어줘야 함
	
	- pageContext → pageScope
	- request → requestScope
	- session → sessionScope
	- application → applicationScope
--%>

<%
	//이 부분을 서블릿이라고 생각하고 데이터를 추가
	request.setAttribute("b", 20);
	session.setAttribute("c", 30);
%>

<h1>b = <%=request.getAttribute("b")%></h1>
<h1>b = ${requestScope.b}</h1>
<h1>b = ${b}</h1>

<h1>c = <%=session.getAttribute("c")%></h1>
<h1>c = ${sessionScope.c}</h1>
<h1>c = ${c}</h1>
