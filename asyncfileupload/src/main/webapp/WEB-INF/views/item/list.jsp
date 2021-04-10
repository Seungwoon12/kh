<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품 리스트</h2>
	<a href="register">상품 등록</a>
	<table border="1">
		<tr>
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
			<th align="center" width="80">수정</th>
			<th align="center" width="80">삭제</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty itemList}">
				<tr>
					<td colspan="5">
						게시물이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${itemList}" var="item">
					<tr>
						<td align="center">${item.itemId}</td>
						<td align="left">${item.itemName}</td>
						<td align="right">${item.price}</td>
						<td align="center">
							<a href="/item/modify?itemId=${item.itemId}">
								상품 수정
							</a>
						</td>
						<td align="center">
							<a href="/item/remove?itemId=${item.itemId}">
								상품 삭제
							</a>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>