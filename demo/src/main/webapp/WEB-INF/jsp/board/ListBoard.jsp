<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 기본 예제</title>
<style type="text/css">
body, table {
	font-size: 9pt;
	font-family: 굴림;
}
th.cl {
	color: #0000CC;
}
</style>
</head>
<body>
	<h2 align="center">게시판 목록 표시 Program</h2>
	<hr>
	<center>
		<%@ page
			import="java.util.Vector,com.example.demo.entity.Board,java.text.SimpleDateFormat"%>
		<jsp:useBean id="brddb" class="com.example.demo.repository.JSPBoardDBCP" scope="page" />
		<%
			Vector<Board> list = brddb.getBoardList();
			int counter = list.size();
			int row = 0;
			if (counter > 0) {
		%>
		<table width="800" border="0" cellpadding="1" cellspacing="3">
			<tr>
				<th class="cl">번호</th>
				<th class="cl">제목</th>
				<th class="cl">작성자</th>
				<th class="cl">작성일</th>
				<th class="cl">작성메일</th>
			</tr>
			<%
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						for (Board brd : list) {
							String color = "papayawhip";
							if (++row % 2 == 0)
								color = "white";
			%>
			<tr bgcolor="<%=color%>"
				onmouseover="this.style.backgroundColor='SkyBlue'"
				onmouseout="this.style.backgroundColor='<%=color%>'">
				<td align="center"><%=brd.getNo()%></td>
				<td align="left"><a href="editboard.jsp?no=<%=brd.getNo()%>"><%=brd.getTitle()%></a></td>
				<td align="center"><%=brd.getName()%></td>
				<td align="center"><%=df.format(brd.getRegdate())%></td>
				<td align="center"><%=brd.getEmail()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
		<hr width="90%">
		<p>
			조회된 게시판 목록 수가
			<%=counter%>개 입니다.
	</center>
	<hr>
	<center>
		<form name="form" method="post" action="editboard.jsp">
			<input type="submit" value="게시물 등록">
		</form>
	</center>
</body>
</html>