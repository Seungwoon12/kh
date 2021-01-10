<%@page import="beans.WorkerDto"%>
<%@page import="java.util.List"%>
<%@page import="beans.WorkerDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	JSP에서는 기본 글자를 text/html로 인식합니다
	따라서 자바코드를 작성할 때에는 특별한 표시를 해야 합니다
	(HTML에서는 이러한 표시가 불가능합니다)
 -->

<% 
	WorkerDao dao = new WorkerDao();
	List<WorkerDto> list = dao.select();
%>

<h1>데이터 개수 : <%=list.size()%></h1>

<%for(WorkerDto dto : list){ %>
	<div>
		<%=dto.getWorker_no()%>
		/
		<%=dto.getWorker_name()%>
		/
		<%=dto.getPosition()%>
	</div>
<%} %>