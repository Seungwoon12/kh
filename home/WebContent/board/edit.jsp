<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="home.beans.*" %>

<%
// 	상세보기처럼 번호를 이용해서 글을 불러온다(조회수 증가는 하지 않음)
	int board_no = Integer.parseInt(request.getParameter("board_no"));
	BoardDao boardDao = new BoardDao();
	BoardDto boardDto = boardDao.find(board_no);
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<script>
	//유형에 따른 select 선택
	$(function(){
		$("select[name=board_header]").val("<%=boardDto.getBoard_header_string()%>"); 
	});
</script>

<div class="outbox" style="width:800px">
	<div class="row center">
		<h2>게시글 수정</h2>
	</div>
	<div class="row center">상대방에 대한 인신공격은 예고 없이 삭제될 수 있습니다</div>
	
	<form action="<%=request.getContextPath()%>/board/edit.do" method="post">
	
	<!-- 사용자 몰래 번호를 첨부 -->
	<input type="hidden" name="board_no" value="<%=boardDto.getBoard_no()%>">
	
	<div class="row">
		<label>말머리</label>
		<select name="board_header" class="input">
			<option value="">말머리를 선택하세요</option>
			<option value="정보">정보</option>
			<option value="공지">공지</option>
			<option value="유머">유머</option>
			<option value="자유">자유</option>
		</select>	
	</div>
	
	<div class="row">
		<label>제목</label>
		<input type="text" class="input" name="board_title" value="<%=boardDto.getBoard_title()%>" required>
	</div>
	
	<div class="row">
		<label>내용</label>
		<!-- textarea에는 value속성이 없습니다 -->
		<textarea name="board_content" class="input" required rows="10"><%=boardDto.getBoard_content()%></textarea>
	</div>
	
	<div class="row">
		<input type="submit" class="input" value="수정">
	</div>
	 
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>