<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSTL을 이용한 조건 구문 구현
	- <c:if> 를 이용하여 단독 조건을 구현할 수 있다(주의 : <c:else>는 없다)
	- <c:choose> 를 이용하여 그룹 조건을 구현할 수 있다.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>부자 판독기</h1>
<form action="test02.jsp" method="get">
	<input type="text" name="money" placeholder="자산 입력" value="${param.money}">
	<input type="submit" value="확인">
</form>

<!-- 단독조건 -->
<c:if test="${param.money >= 100000}">
	<h2>당신은 부자입니다!</h2>
</c:if>
<c:if test="${param.money < 100000}">
	<h2>당신은 부자가 아니에요!</h2>
</c:if>

<!-- 그룹조건 -->
<c:choose>
	<c:when test="${empty param.money}">
		<!-- 아무것도 하지 않는다 -->
	</c:when>
	<c:when test="${param.money >= 100000}">
		<h2>당신은 부자입니다!</h2>
	</c:when>
	<c:otherwise>
		<h2>당신은 부자가 아닙니다!</h2>
	</c:otherwise>
</c:choose>