<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.removeAttribute("id");
%>
<h3>Logout 되셨습니다.</h3>
<a href="/login">Login Page로 이동</a>