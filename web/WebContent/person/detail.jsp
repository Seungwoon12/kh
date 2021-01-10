  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<!-- 
	상세보기엔 PK가 필요하다
 -->
<%
	int person_no = Integer.parseInt(request.getParameter("person_no"));
	PersonDao dao = new PersonDao();
	PersonDto dto = dao.find(person_no);
%>

<!doctype html>
<html>
	<head>
		<title>인원 정보</title>
		<link rel="stylesheet" type="text/css" href="../css/common.css">
		<style>
			.outbox{
				width:400px;
			}
		</style>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script>
		
		</script>
	</head>
	<body>
		<div class="outbox">
			<div class="row center"> 
				<h1>인원 상세정보</h1>
			</div>
			<div class="row">
				<table class="table table-border table-highlight">
					<tbody>
						<tr>
							<th>번호</th>
							<td><%=dto.getPerson_no()%></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><%=dto.getPerson_name()%></td>
						</tr>
						<tr>
							<th>자바점수</th>
							<td><%=dto.getJavascore()%></td>
						</tr>
						<tr>
							<th>DB점수</th>
							<td><%=dto.getDbscore()%></td>
						</tr>
						<tr>
							<th>총점</th>
							<td><%=dto.getTotal()%></td>
						</tr>
						<tr>
							<th>평균</th>
							<td><%=dto.getAverage()%></td> 
						</tr>
						<tr>
							<th>성별</th>
							<td><%=dto.getGender()%></td>
						</tr>
						<tr>
							<th>등록일</th>
							<td><%=dto.getRegist_date()%></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>