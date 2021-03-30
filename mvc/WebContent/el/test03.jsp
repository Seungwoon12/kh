<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 검색 화면 구현 -->

<%
	String key = request.getParameter("key");
%>
<%if(key == null){ %>
	<input type="text" name="key" value="">
<%}else{ %>
	<input type="text" name="key" value="<%=request.getParameter("key")%>">
<%} %>

<hr>
 
<input type="text" name="key" value="${param.key}">