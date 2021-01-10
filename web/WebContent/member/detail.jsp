<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%
	//회원 한 명(MemberDto)의 정보를 보여주려면 최소한 회원 번호는 있어야 한다.
	int member_no = Integer.parseInt(request.getParameter("member_no"));
	
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.find(member_no); 
%> 

<!doctype html>
<html>
	<head>
		<title>회원 상세 정보</title>
		<link rel="stylesheet" type="text/css" href="../css/common.css">
		<style>
			.outbox {
				width:400px;
			}
		</style>
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script>
		
		</script>
	</head>
	<body>
		<div class="outbox">
			<div class="row center">
				<h1>회원 상세 정보</h1>
			</div>
			<div class="row">
				<table class="table table-border">
					<tbody>
						<tr>
							<th width="25%">회원번호</th>
							<td class="left"><%=dto.getMember_no()%></td>
						</tr>
						<tr>
							<th>회원아이디</th>
							<td class="left"><%=dto.getMember_id()%></td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td class="left"><%=dto.getMember_nick()%></td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td class="left"><%=dto.getMember_birth()%></td>
						</tr>
						<tr>
							<th>권한</th>
							<td class="left"><%=dto.getMember_auth()%></td>
						</tr>
						<tr>
							<th>포인트</th>
							<td class="left"><%=dto.getMember_point()%>점</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td class="left"><%=dto.getMember_join()%></td>
						</tr>
					</tbody>
				</table>
				<div class=row>
					<a href="delete.do?member_no=<%=dto.getMember_no()%>">삭제</a>
				</div>
			</div>
		</div>
	</body>
</html>