<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
	$(document).ready(function () {
		var formObj = $("#member")
		
		$("#btnRegister").on("click", function () {
			formObj.attr("action", "/member/sign-up")
			formObj.attr("method", "post")
			formObj.submit();
		})
	})
</script>

<body>
	<h2>회원 가입</h2>
	
	<form:form modelAttribute="member" action="sign-up">
		<table>
			<tr>
				<td>아이디</td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><form:input path="phoneNumber"/></td>
			</tr>
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister">등록</button>
	</div>
</body>
</html>