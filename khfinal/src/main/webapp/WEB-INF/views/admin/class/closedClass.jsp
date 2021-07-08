<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
    
<jsp:include page="/WEB-INF/views/adminTemplate/header.jsp"></jsp:include>

<div class="outbox">
	<h2>종료된 클래스</h2>
	
	<select>
		<option>클래스명</option>
		<option>크리에이터명</option>
	</select>
	<input type="text" placeholder="검색어를 입력하세요.">
	<button>검색</button>
	
	<select style=float:right;>
		<option>최신순</option>
		<option>판매순</option>
		<option>오래된순</option>
	</select>
	
	<br><br><br>
	
	<table class="swTable">
		<tr>
			<th>No.</th>
			<th>클래스명</th>
			<th>크리에이터</th>
			<th>오픈일</th>
			<th>종료일</th>
			<th>판매수</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="6">클래스가 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="adminOffclassVO">
					<tr>
						<td>${adminOffclassVO.classNo}</td>
						<td>${adminOffclassVO.className}</td>
						<td>${adminOffclassVO.memberNick}</td>
						<td>${adminOffclassVO.classStart}</td>
						<td>${adminOffclassVO.classEnd}</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${adminOffclassVO.count}"/>건</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	
	</table>

</div>




<jsp:include page="/WEB-INF/views/adminTemplate/footer.jsp"></jsp:include>