<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %> 
<%@ page import="java.sql.*" %>

<%
	try{
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
	
		Connection con = JdbcUtil.getConnection("web", "web");
		String sql = "select board_title, board_content, board_writer, board_time, board_read from board where board_no="+board_no;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
	
		if(rs.next()) {
			String title = rs.getString("board_title");
			String content = rs.getString("board_content");
			String writer = rs.getString("board_writer");
			Date time = rs.getDate("board_time");
			int read = rs.getInt("board_read");
			
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	제목: <%=title%>
	<hr>
	작성자: <%=writer%>
	<hr>
	작성일: <%=time%>
	<hr>
	조회: <%=read%>
	<hr>
	내용: <%=content%>
	
<%
	read++;
	sql = "update board set board_read = "+read+ "where board_no= " +board_no;
	ps = con.prepareStatement(sql);
	ps.executeUpdate();
	con.close();
	
		}
	}catch(Exception e) {
		e.printStackTrace();
		response.sendError(500);
	}
%>
</body>
</html>