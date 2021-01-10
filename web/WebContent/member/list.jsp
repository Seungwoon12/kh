<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	//페이지 인쇄에 필요한 데이터를 준비
	MemberDao dao = new MemberDao(); 
	List<MemberDto> list = dao.select();
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member 목록</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<style>
	.outbox {
		width: 700px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
</script>
</head>
<body>
	<div class="outbox">
		<div class="row center">
			<h1>회원 목록</h1>
		</div>
		<div class="row">
			<table class="table table-border">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>아이디</th>
						<th>닉네임</th>
						<th>생년월일</th>
						<th>권한</th>
						<th>포인트</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody>
					<%for(MemberDto dto : list){ %>
					<tr>
						<td><%=dto.getMember_no()%></td>
						<td><%=dto.getMember_id()%></td>
						<td><%=dto.getMember_pw()%></td>
						<td><%=dto.getMember_birth()%></td>
						<td><%=dto.getMember_auth()%></td>
						<td><%=dto.getMember_point()%></td>
						<td><%=dto.getMember_join()%></td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>