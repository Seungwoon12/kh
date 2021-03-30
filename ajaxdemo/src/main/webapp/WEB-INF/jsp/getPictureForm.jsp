<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	$(document).ready(function () {
		$('#inputFile').on("change", function (event) {
			var files = event.target.files
			var file = files[0]
			var formData = new FormData()
			
			console.log('file: ' + file)
			
			if (file === undefined) {
				alert('파일을 입력해주세요.')
			} else {
				formData.append("file", file)
				
				$.ajax({
					type: "post",
					url: "/postUploadAjax",
					data: formData,
					dataType: "text",
					processData: false,
					contentType: false,
					success: function (data) {
						alert(data)
					}
				})
			}
		})
		
	})
</script>
<body>
	<h2>Ajax 파일 업로드</h2>
	<div>
		<input type="file" id="inputFile">
	</div>
</body>
</html>