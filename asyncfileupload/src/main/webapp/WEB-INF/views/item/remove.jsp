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
		var formObj = $("#item")
		
		$("#btnRemove").on("click", function () {
			formObj.attr("action", "/item/remove")
			formObj.attr("method", "post")
			formObj.submit();
		})
		
		$("#btnList").on("click", function () {
			self.location = "/item/list"
		})
		function checkImageType (fileName) {
			var pattern = /jpg|gif|png|jpeg/i
			
			return fileName.match(pattern)
		}
		
		function getOriginalName (fileName) {
			if (checkImageType (fileName)) {
				return;
			}
			
			var idx = fileName.indexOf("_") + 1;
			
			return fileName.substr(idx);
		}
		
		function getThumbnailName (fileName) {
			var front = fileName.substr(0, 12)
			var end = fileName.substr(12)
			
			console.log("front: " + front)
			console.log("end: " + end)
			
			return front + "s_" + end
		}
		
		$.getJSON("/item/getAttach/" + itemId, function (list) {
			$(list).each(function () {
				var data = this
				
				var str = ""
				
				if (checkImageType(data)) {
					str = "<div><a href='/item/displayFile?fileName=" + 
							data + "'>" +
							"<img src='/item/displayFile?fileName=" + 
							getThumbnailName(data) + "'/>" +
							"</a><span>x</span></div>"
				} else {
					str = "<div><a href='/item/displayFile?fileName=" + 
							data + "'>" + getOriginalName(data) +
							"</a><span>x</span></div>"
				}
				
				$(".uploadedList").append(str)
			})
		})
	})
</script>

<body>
	<h2>상품 삭제</h2>
	
	<form:form modelAttribute="item" action="delete">
		<form:hidden path="itemId"/>
		
		<table>
			<tr>
				<td>상품명</td>
				<td><form:input path="itemName"/></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><form:input path="price"/>&nbsp;원</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" id="inputFile">
					<div class="uploadedList"></div>
				</td>
			</tr>
			<tr>
				<td>상품 설명</td>
				<td><form:textarea path="description"/></td>
			</tr>
		</table>
	</form:form>
	
	<div>
		<button type="submit" id="btnRemove">삭제</button>
		<button type="submit" id="btnList">상품 보기</button>
	</div>
</body>
</html>