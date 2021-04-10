<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<jsp:include page="/WEB-INF/views/adminTemplate/header.jsp"></jsp:include>

<style>

	.paginav {
	  	margin:0;
	   	padding:0;
	    list-style: none;
	}
	.paginav > li {
	    display:inline-block;
	    padding:0.1rem;
	    min-width:2rem;
	    text-align: center;
	    /*border:1px solid transparent;*/
	}
	
	
	.paginav > li > a {
	    text-decoration: none;
	    
	}
	a{
		color:black;
	}
	
	
	.paginav > li.active {
    	/*border:1px solid gray;*/
    	cursor: pointer;
    	box-shadow: 0px 0px 0px 1px lightgray;
	}
	
	.paginav > li.active > a {
		color: red;
	}
	
	
	.paginav > li > a:hover{
		text-decoration: underline;
	}

</style>


<script>
	
	$(function(){
		
	});
	

</script>

<div class="outbox">
	<h2>회원 목록</h2>
	
	<div class="row">
		<form action="list" method="post">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nick">닉네임</option>
			</select>
			<input type="text" name="key" placeholder="검색어를 입력하세요.">
			<input type="submit" id="searchBtn" value="검색">
		</form>
	</div>
	
	
	<br>
	
	<div class="row center">
		<table class="swTable">
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>닉네임</th>
				<th>회원등급</th>
				<th>구매내역</th>
				<th>회원정보</th>
			</tr>
			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td colspan="6">검색결과가 존재하지 않습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list}" var="adminMemberVO">
						<tr>
							<td>${adminMemberVO.memberNo}</td>
							<td>${adminMemberVO.memberId}</td>
							<td>${adminMemberVO.memberNick}</td>
							<td>${adminMemberVO.memberAuth}</td>
							<td>${adminMemberVO.orderCount}</td>
							<td><a href="#">조회</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	
	
	<!--페이지 네비게이션-->
	<div class="row center">
		<ul class="paginav center">
		
			<c:if test="${not empty list}">
				
				<li>
					<c:if test="${startNum != 1}">
						<a href="list?p=${startNum - 1}">&lt; 이전</a>	
					</c:if>
				</li>
					
				
				<c:forEach var="i" begin="${startNum}" end="${endNum}" step="1">
					<c:if test="${pageNo == i}">
						<li class="active">
					</c:if>
					<c:if test="${pageNo != i}">
						<li>
					</c:if>
							<a href="list?p=${i}">${i}</a>
						</li>	
				</c:forEach>
			
				
				<li>
					<c:if test="${pageSize > endNum}">	
						<a href="list?p=${endNum + 1}">다음 &gt;</a>
					</c:if>
				</li>
				
			</c:if>
		</ul>
	</div>

</div>

<jsp:include page="/WEB-INF/views/adminTemplate/footer.jsp"></jsp:include>
