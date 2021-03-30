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
	<h2>게시판 리스트</h2>
	<a href="register">글쓰기</a>
	<table border="1">
		<tr>
			<th align="center" width="80">번호</th>
			<th align="center" width="320">제목</th>
			<th align="center" width="100">작성자</th>
			<th align="center" width="160">등록일자</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">
						게시물이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="board">
					<tr>
						<td align="center">${board.boardNo}</td>
						<td align="left">
							<a href="/board/read?boardNo=${board.boardNo}">
								${board.title}
							</a>
						</td>
						<td align="right">${board.writer}</td>
						<td align="left">
							<javatime:format value="${board.regDate}"
								pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>