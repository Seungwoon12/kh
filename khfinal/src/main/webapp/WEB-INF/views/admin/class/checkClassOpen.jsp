<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<jsp:include page="/WEB-INF/views/adminTemplate/header.jsp"></jsp:include>

<script>

	$(function(){
		
		$("#checkBtn").click(function(){
			
			var classNo = $("#classNo").text();
			self.location = "checkClassOpenDetail?classNo="+classNo;
			
		});
		
		
	});
	


</script>

<div class="outbox">
	<h2>크리에이터 클래스 오픈 검수</h2>
	
	<select>
		<option>아이디</option>
		<option>크리에이터명</option>
	</select>
	<input type="text" placeholder="검색어를 입력하세요.">
	<button>검색</button>
	
	<br><br>
	
	<!-- 게시판 페이징 구현 -->
	
	<div class="row center">
		<table class="swTable">
			<tr>
				<th>No.</th>
				<th>신청일</th>
				<th>아이디</th>
				<th>크리에이터명</th>
				<th>상태</th>
				<th>검수</th>
			</tr>
			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td colspan="6">검색결과가 존재하지 않습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list}" var="adminOffclassVO">
						<tr>
							<td id="classNo">${adminOffclassVO.classNo}</td>
							<td>${adminOffclassVO.classRegdate}</td>
							<td>${adminOffclassVO.memberId}</td>
							<td>${adminOffclassVO.memberNick}</td>
							<c:if test="${adminOffclassVO.classCheck == '반려'}">
								<td>반려</td>
							</c:if>
							<c:if test="${adminOffclassVO.classCheck == '검수완료'}">
								<td>승인</td>
							</c:if>
							<c:if test="${adminOffclassVO.classCheck == '검수대기'}">
								<td>검수대기</td>
							</c:if>
							
							<c:if test="${adminOffclassVO.classCheck == '반려'}">
								<td>검수완료</td>
							</c:if>
							<c:if test="${adminOffclassVO.classCheck == '검수완료'}">
								<td>검수완료</td>
							</c:if>
							<c:if test="${adminOffclassVO.classCheck == '검수대기'}">
								<td><button type="submit" id="checkBtn">검수하기</button></td>		
							</c:if>
							
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	
</div>

<jsp:include page="/WEB-INF/views/adminTemplate/footer.jsp"></jsp:include>