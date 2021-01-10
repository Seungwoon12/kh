<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

	session.setAttribute("sample", "hello");

%>
<h1>sessionId = <%=session.getId()%></h1>
<h1>sample = <%=session.getAttribute("sample") %></h1>