<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
	$(document).ready(function(){
		var formObj = $("#member")
		
		$("#btnRegister").on("click", function(){
			formObj.attr("action", "/user/register")
			formObj.attr("method", "post")
			formObj.submit();
		})
	})

</script>

<body>
	<h2>등록 페이지입니다!</h2>
	
	<form:form modelAttribute="member" action="register">
		<table>
			<tr>
				<td>사용자 아이디</td>
				<td><form:input path="userId"/></td>
			</tr>
			<tr>
				<td>사용자 비밀번호</td>
				<td><form:input path="userPw"/></td>
			</tr>
			<tr>
				<td>사용자 이메일</td>
				<td><form:input path="userEmail"/></td>
			</tr>
			<tr>
				<td>사용자 휴대번호</td>
				<td><form:input path="userPhoneNum"/></td>
			</tr>
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister">등록하기</button>
	</div>
</body>
</html>