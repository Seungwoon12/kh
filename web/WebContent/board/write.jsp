<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="write.do" method="post">
		<table border="1">
			<tbody>
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="board_writer" required>
					</td>
				</tr>
				<tr>
					<th>말머리</th>
					<td>
						<select name="board_header">
							<option value="">말머리를 선택하세요</option>
							<option>정보</option>
							<option>공지</option>
							<option>유머</option>
							<option>자유</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="board_title" required>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="board_content" required></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" value="게시글 등록">
					</td>	
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>