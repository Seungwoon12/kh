<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<!-- 
	수정과 등록의 입력화면은 매우 유사하다
	
	백엔드에서 실행될 데이터베이스 작업의 SQL명령은 다음과 같다.
	update board 
	set board_header=?, board_title=?, board_content=?
	where board_no=?
	입력화면에서 ?에 해당하는 값들을 보내줘야 한다	 
	
	**** 이 페이지는 특정 글의 정보가 미리 표시되도록 구성해야 한다. *****
	- 따라서 글 번호가 반드시 필요하다
	- 상세보기 페이지처럼 글 번호를 이용해서 정보를 불러온 뒤 화면에 표시해줘야 한다
 -->
<%
	int board_no = Integer.parseInt(request.getParameter("board_no"));
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.find(board_no);
%>

<h1>게시글 정보 수정</h1>

<form action="edit.do" method="post">
	<!-- 보내긴 해야하는데 보여주기 싫으면 input[type=hidden]을 사용한다 -->
	<input type="hidden" name="board_no" value="<%=dto.getBoard_no()%>">
	말머리 : <%=dto.getBoard_header()%>
	<select name="board_header">
		<option value="">말머리를 선택하세요</option>
		<!--
		<option <%if(dto.getBoard_header() != null && dto.getBoard_header().equals("정보")) { %>
			 selected
			 <%} %>>정보</option>
		<option <%if(dto.getBoard_header() != null && dto.getBoard_header().equals("공지")) { %>
		 selected
		 <%} %>>공지</option>
		<option <%if(dto.getBoard_header() != null && dto.getBoard_header().equals("유머")) { %>
		 selected
		 <%} %>>유머</option>
		<option <%if(dto.getBoard_header() != null && dto.getBoard_header().equals("자유")) { %>
		 selected
		 <%} %>>자유</option>
		 --> 
		<option <%if(dto.is("정보")){%>selected<%}%>>정보</option>
		<option <%if(dto.is("공지")){%>selected<%}%>>공지</option>
		<option <%if(dto.is("유머")){%>selected<%}%>>유머</option>
		<option <%if(dto.is("자유")){%>selected<%}%>>자유</option>
	</select>
	<br><br>
	제목 : <input type="text" name="board_title" value="<%=dto.getBoard_title()%>">
	<br><br>
	내용 : <textarea name="board_content"><%=dto.getBoard_content()%></textarea>
	<br><br>
	<input type="submit" value="수정">
</form>