<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="login.do" method="post">
<div class="outbox" style="width:400px;">
	<div class="row center">
		<h2>로그인</h2>
	</div>
	<div class="row">
		<label>ID</label>
		<input type="text" name="member_id" class="input" required>
	</div>
	<div class="row">
		<label>Password</label>
		<input type="password" name="member_pw" class="input" required>
	</div>
	
	<c:if test="${not empty param.error}">
		<!-- 오류 메세지 : 특정 상황에서만 출력되어야 하는 태그(주소에 error라는 파라미터가 있다면) -->
		<div class="row center" style="color:red;">
			입력하신 정보가 맞지 않습니다
		</div>
	</c:if>
	
	<div class="row">
		<input type="submit" value="로그인" class="input">
	</div>
</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
