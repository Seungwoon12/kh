<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	//페이지 인쇄에 필요한 데이터를 준비
	BoardDao dao = new BoardDao();
	List<BoardDto> list = dao.select(); 
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<style>
	.outbox {
		width: 600px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
</script>
</head>
<body>
	<div class="outbox">
		<div class="row center">
			<h1>게시판 목록</h1>
		</div>
		<div class="row">
			<table class="table table-border">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<%for(BoardDto dto : list){ %>
					<tr>
						<td><%=dto.getBoard_no()%></td>
						<td>
							<a href="detail.jsp?board_no=<%=dto.getBoard_no()%>">
								<%=dto.getBoard_title()%>
							</a>
						</td>
						<td><%=dto.getBoard_writer()%></td>
						<td><%=dto.getBoard_time()%></td> 
						<td><%=dto.getBoard_read()%></td>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>
