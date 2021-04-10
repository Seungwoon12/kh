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
		
		$("#btnModify").on("click", function () {
			var boardNo = $("#boardNo")
			var boardNoVal = boardNo.val();
			
			self.location = "/board/modify?boardNo=" + boardNoVal
		})
		
		$("#btnList").on("click", function () {
			self.location = "/board/list"
		})
		
		$("#btnRemove").on("click", function () {
			formObj.attr("action", "/board/remove")
			formObj.submit();
		})
	})
</script>

<body>
	<h2>게시글 읽기</h2>
	
	<form:form modelAttribute="myBatisBoard">
		<form:hidden path="boardNo"/>
		
		<table>
			<tr>
				<td>제목</td>
				<td><form:input path="title" readonly="true"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><form:input path="writer" readonly="true"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><form:input path="content" readonly="true"/></td>
			</tr>
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnModify">수정</button>
		<button type="submit" id="btnList">게시글 보기</button>
		<button type="submit" id="btnRemove">게시글 삭제</button>
	</div>
</body>
</html>