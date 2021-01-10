<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	//페이지 인쇄에 필요한 데이터를 준비
	//- 상황1 : http://localhost:8888/web/member/list2.jsp 로 접속하는 경우
	//- 상황2 : http://localhost:8888/web/member/list2.jsp?keyword=kh 로 접속하는 경우
	//- 상황1은 파라미터가 없으므로 목록으로 간주, 상황2는 검색으로 간주하여 처리
	
	String keyword = request.getParameter("keyword");
	MemberDao dao = new MemberDao();
	List<MemberDto> list;
	if(keyword == null){//목록
		list = dao.select();	
	}
	else{
		list = dao.select(keyword); 
	}
	
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
	<h1>keyword = <%=keyword%></h1>

	<div class="outbox">
	
		<!-- 제목 영역 -->
		<div class="row center">
			<h1>회원 목록</h1>
		</div>
		
		<!-- 검색창 영역 -->
		<div class="row center">
			<form action="list2.jsp" method="get">
				<input type="text" name="keyword" placeholder="검색어 입력" required class="input input-inline">
				<input type="submit" value="검색" class="input input-inline">
			</form>
		</div>
		
		<!-- 표시 영역 -->
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
