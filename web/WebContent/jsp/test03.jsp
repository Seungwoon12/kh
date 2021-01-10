<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>

<%
	WorkerDao dao = new WorkerDao();
	List<WorkerDto> list = dao.select();
%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../css/common.css">
		<style>
			.outbox {
				width:500px;
			}
		</style>
	</head>
	<body>
		<div class="outbox">
			<div class="row center">
				<h1>작업자 목록</h1>
			</div>
			<div class="row">
				<table class="table table-border">
					<thead>
						<tr>
							<th>번호</th>
							<th>이름</th>
							<th>고용일</th>
							<th>급여액</th>
							<th>직급</th>
						</tr>
					</thead>
					<tbody>
						<%for(WorkerDto dto : list){ %>
						<tr>
							<td><%=dto.getWorker_no()%></td>
							<td><%=dto.getWorker_name()%></td>
							<td><%=dto.getHire_date()%></td>
							<td><%=dto.getSalary()%></td>
							<td><%=dto.getPosition()%></td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>