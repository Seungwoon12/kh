<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	//요청 예상 주소
	//상황1 - http://localhost:8888/web/board/list3.jsp?type=board_title&keyword=hello
	//상황2 - http://localhost:8888/web/board/list3.jsp
	//상황3 - http://localhost:8888/web/board/list3.jsp?type=board_title
	//상황4 - http://localhost:8888/web/board/list3.jsp?keyword=hello 
	
	//검색 : 상황1
	//목록 : 상황2, 상황3, 상황4
	
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	
	boolean isSearch = type != null && keyword != null;
	
	BoardDao dao = new BoardDao();
	List<BoardDto> list;
	if(isSearch){
		list = dao.select(type, keyword);
	} 
	else{
		list = dao.select();
	}
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
	<h1>isSearch = <%=isSearch%></h1>
	<div class="outbox">
		<div class="row center">
			<h1>2차 검색 샘플</h1>
		</div>
		<div class="row right">
			<a href="write.jsp">글쓰기</a>
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
						<td width="40%">
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
		
		<div class="row center">
			<!-- 
				검색 데이터 입력 및 전송 영역
				- name="type" 형태로 검색분류 선택 및 전송
				- name="keyword" 형태로 검색어를 입력 및 전송 
			-->
			<form action="list3.jsp" method="get">
				<select name="type" class="input input-inline">
					<option value="board_title">제목</option>
					<option value="board_writer">작성자</option>
					<option value="board_content">내용</option>
				</select>
				<input type="text" name="keyword" placeholder="검색어" class="input input-inline">
				<input type="submit" value="검색" class="input input-inline">
			</form>
		</div>
	</div>
</body>
</html>
