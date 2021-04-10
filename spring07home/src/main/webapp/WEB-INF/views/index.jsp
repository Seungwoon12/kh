<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- header.jsp를 여기다 좀 불러와줘라... -->
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<div class="outbox" style="width:640px">
	<div class="row center">
		<h2>환영합니다 나와라!</h2>
	</div>
	<div class="row center">
		<img alt="환영 이미지" src="${pageContext.request.contextPath}/resources/image/QR출석.png">
	</div>
</div> 

<!-- footer.jsp를 여기다 좀 불러와줘라... -->
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
