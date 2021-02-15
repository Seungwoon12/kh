<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<%
// 	1. 파라미터로 전달될 경우
// 	String password = request.getParameter("password");
// 	2. 포워드로 전달될 경우
	String password = (String)request.getAttribute("password");
%>

<div class="outbox center" style="width:500px">
	<div class="row">
		<h2>임시 비밀번호 발급 완료</h2>
	</div>
	<div class="row">
		발급된 비밀번호 : <%=password%>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>