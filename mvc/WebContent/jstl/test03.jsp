<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSTL을 이용하여 반복을 수행
	- <c:forEach>
	- <c:forTokens>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- for(int i=1; i<=10; i++){ } 과 동일한 JSTL 구문 --%>
<c:forEach var="i" begin="1" end="10" step="1">
	<h1>Hello! ${i}</h1>
</c:forEach>

<%-- 
	int[] arr = new int[]{10, 20, 30, 40, 50};
	for(int i : arr){ } 
	과 동일한 JSTL 구문 
--%>

<c:set var="arr" value="10,20,30,40,50"></c:set>
<c:forEach var="i" items="${arr}">
	<h2>${i}</h2>
</c:forEach>

<%-- forTokens는 forEach에 구분자(delims)를 하나 더 지정하게 되어 있다 --%>
<c:forTokens var="i" items="${arr}" delims=",">
	<h2>${i}</h2>
</c:forTokens>