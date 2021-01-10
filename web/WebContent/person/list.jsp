<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	//페이지 인쇄에 필요한 데이터를 준비
	PersonDao dao = new PersonDao();
	List<PersonDto> list = dao.select();
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person 목록</title>
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
			<h1>학생 목록</h1>
		</div>
		<div class="row">
			<table class="table table-border">
				<thead>
					<tr>
						<th>학생번호</th>
						<th>학생이름</th>
						<th>자바점수</th>
						<th>디비점수</th>
						<th>성별</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<%for(PersonDto dto : list){ %>
					<tr>
						<td><%=dto.getPerson_no()%></td>
						<td>
						<!-- 이름에 링크를 걸어서 상세 페이지로 연결(반드시 번호를 전달) -->
						<a href="detail.jsp?person_no=<%=dto.getPerson_no()%>">
							<%=dto.getPerson_name()%>
						</a>
						</td>
						<td><%=dto.getJavascore()%></td>
						<td><%=dto.getDbscore()%></td> 
						<td><%=dto.getGender()%></td>
						<td><%=dto.getRegist_date()%></td>
					</tr> 
					<%} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>