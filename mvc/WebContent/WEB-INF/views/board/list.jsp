<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">

<table class="table table-border">
	<thead>
		<tr>
			<th>번호</th>
			<th width="45%">제목</th> 
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="boardDto" items="${list}">
		<tr>
			<td>${boardDto.board_no}</td>
			<td class="left">
				<c:if test="${not empty boardDto.board_header}">
					[${boardDto.board_header}]
				</c:if>
				${boardDto.board_title}
			</td>
			<td>${boardDto.board_writer}</td>
			<td>${boardDto.board_time}</td>
			<td>${boardDto.board_read}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>