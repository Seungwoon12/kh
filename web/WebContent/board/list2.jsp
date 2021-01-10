<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	//페이지 인쇄에 필요한 데이터를 준비
	// - 목록 코드와 검색 코드를 구분하여 실행
	// - parameter인 keyword를 수신한 뒤 유무를 이용하여 검색/목록을 구분해야 한다
	// - 알아야 할 명령 : 서블릿의 req.getParameter()와 같은 명령이 무엇인지 알아야 한다
	// - JSP에는 매개변수 대신 "내장객체" 가 존재한다(request, response, ...)
	
	String keyword = request.getParameter("keyword");
	
	BoardDao dao = new BoardDao();
	//List<BoardDto> list = 목록 or 검색결과;
	List<BoardDto> list;
	if(keyword == null){//keyword가 없다면
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
					<%if(!list.isEmpty()){ %>
						<%for(BoardDto dto : list){ %>
						<tr>
							<td><%=dto.getBoard_no()%></td>
							<td><%=dto.getBoard_title()%></td>
							<td><%=dto.getBoard_writer()%></td>
							<td><%=dto.getBoard_time()%></td> 
							<td><%=dto.getBoard_read()%></td>
						</tr>
						<%} %>
					<%}else { %>
						<tr>
							<td colspan="5">데이터가 존재하지 않습니다</td>
						</tr>
					<%} %>
				</tbody>
			</table>
		</div>
		
		<div class="row center">
			<!-- 검색 데이터 입력 및 전송 영역 -->
			<form action="list2.jsp" method="get">
				<input type="text" name="keyword" placeholder="검색어" class="input input-inline">
				<input type="submit" value="검색" class="input input-inline">
			</form>
		</div>
	</div>
</body>
</html>
