<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="join.do" method="post">
		ID : <input type="text" name="member_id" required><br><br>
		PW : <input type="password" name="member_pw" required><br><br>
		NICK : <input type="text" name="member_nick" required><br><br>
		BIRTH : <input type="date" name="member_birth" required><br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>