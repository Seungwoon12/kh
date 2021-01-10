<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%for(int i=1; i <= 100; i++){ %>
	<h3>
		<%=i%> 
		- 
		<%if(i % 2 != 0){ %>
			홀수
		<%} else { %>
			짝수
		<%} %>
	</h3>
<%} %>