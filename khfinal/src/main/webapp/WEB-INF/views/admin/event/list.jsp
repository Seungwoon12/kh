<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<jsp:include page="/WEB-INF/views/adminTemplate/header.jsp"></jsp:include>

<div class="outbox">
	
	<h2>이벤트 목록</h2>
	
	<input type="text" placeholder="이벤트명을 입력하세요.">
	<button>검색</button>
	
	<br><br><br>
	
	<table class="swTable">
		<tr>
			<th>이벤트번호</th>
			<th>이벤트명</th>
			<th>이벤트기간</th>
			<th>상태</th>
			<th>이벤트정보</th>
		</tr>
		<c:choose>
			<c:when test="${false}">
				<tr>
					<td colspan="5">검색결과가 존재하지 않습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>3</td>
					<td>회원가입이벤트</td>
					<td>2021-04-02 ~ 2021-05-02</td>
					<td>진행중</td>
					<td><a href="#">조회</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td>친구추천이벤트</td>
					<td>2021-03-02 ~ 2021-04-30</td>
					<td>진행중</td>
					<td><a href="#">조회</a></td>
				</tr>
				<tr>
					<td>1</td>
					<td>새해이벤트</td>
					<td>2021-01-01 ~ 2021-01-30</td>
					<td>종료</td>
					<td><a href="#">조회</a></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>

</div>




<jsp:include page="/WEB-INF/views/adminTemplate/footer.jsp"></jsp:include>