<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Login</title>
</head>
<body>
	<form action="/login2" method="post">
		<table border=0 width=400 height=100>
			<tr bgcolor="yellow">
				<td align=right><font size=2> ID : </font></td>
				<td><input type="text" name="id" size=10> <input
					type="checkbox" name="box">ID 저장</td>
			</tr>
			<tr bgcolor="yellow">
				<td align=right><font size=2> PW : </font></td>
				<td><input type="password" name="pass" size=12></td>
			</tr>
			<tr bgcolor="yellow">
				<td colspan=2 align=center><input type="submit" value="Login">
					<input type="reset" value="다시 작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>