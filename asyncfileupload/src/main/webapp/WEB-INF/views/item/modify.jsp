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
		
		$("#btnModify").on("click", function () {
			formObj.attr("action", "/item/modify")
			formObj.attr("method", "post")
			formObj.submit();
		})
		
		$("#btnList").on("click", function () {
			self.location = "/item/list"
		})
		
		$(".uploadedList").on("click", "span", function () {
			$(this).parent("div").remove();
		})
		
		// 정규 표현식으로 *.jpg, *.gif, *.png, *.jpeg 파일중 하나 검출
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
		
		// 사진 추가 및 수정에 대한 고려가 필요
		var itemId = ${item.itemId}
		
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
		
		$("#item").submit(function(event) {
			event.preventDefault()
			
			var that = $(this)
			
			var str = ""
			
			$(".uploadedList a").each(function(idx) {
				var value = $(this).attr("href")
				
				console.log('value: ' + value)
				
				value = value.substr(27);
				
				console.log('value: ' + value)
				
				str += "<input type='hidden' name='files[" + idx + 
					"]' value = '" + value + "'>";
			})
			
			console.log("str: " + str)
			
			that.append(str)
			
			that.get(0).submit()
		})
		
		$("#inputFile").on("change", function(event) {
			console.log("change")
			
			var files = event.target.files
			var file = files[0]
			
			console.log(file)
			
			var formData = new FormData();
			
			formData.append("file", file);
			
			$.ajax({
				url: "/item/uploadAjax",
				data: formData,
				dataType: "text",
				processData: false,
				contentType: false,
				type: "POST",
				success: function (data) {
					console.log(data)
					
					var str = ""
					
					if (checkImageType(data)) {
						str = "<div><a href='/item/displayFile?fileName=" + 
								data + "'>" + 
								"<img src='/item/displayFile?fileName=" +
								getThumbnailName(data) + "'>" +
								"</a><span>x</span></div>"
					} else {
						str = "<div><a href='/item/displayFile?fileName=" +
								data + "'>" + 
								"</a><span>x</span></div>"
					}
					
					$(".uploadedList").append(str);
				}
			})
		})
	})
</script>

<body>
	<h2>게시물 수정</h2>
	
	<form:form modelAttribute="item" action="modify" 
				enctype="multipart/form-data">
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
		<button type="submit" id="btnModify">수정 완료</button>
		<button type="submit" id="btnList">게시글 보기</button>
	</div>
</body>
</html>