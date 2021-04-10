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
		var formObj = $("#myBatisBoard")
		
		$("#btnRegister").on("click", function () {
			formObj.attr("action", "/board/register")
			formObj.attr("method", "post")
			formObj.submit();
		})
		
		$("#btnList").on("click", function () {
			self.location = "/board/list"
		})
	})
</script>

<body>
	<h2>게시글 쓰기</h2>
	
	<form:form modelAttribute="myBatisBoard" action="register">
		<table>
			<tr>
				<td>제목</td>
				<td><form:input path="title"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><form:input path="writer"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><form:input path="content"/></td>
			</tr>
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnRegister">등록</button>
		<button type="submit" id="btnList">게시글 보기</button>
	</div>
</body>
</html>