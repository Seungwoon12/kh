  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="home.beans.*" %>
<%
// 	목록,검색을 위해 필요한 프로그래밍 코드
// 	type : 분류 , key : 검색어
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	String key = request.getParameter("key");
	boolean isSearch = type != null && key != null;
	
	BoardDao dao = new BoardDao();
// 	List<BoardDto> list = 목록 or 검색;
	List<BoardDto> list; 
	if(isSearch){
		list = dao.select(type, key);
	}
	else{
		list = dao.select();
	}
%>    
    

<jsp:include page="/template/header.jsp"></jsp:include>

<script>
	$(function(){
		//.write-btn을 누르면 글쓰기 페이지로 이동
		$(".write-btn").click(function(){
			//상대경로
			//location.href = "write.jsp";
			//$(location).attr("href", "write.jsp");
			
			//절대경로
			//location.href = "http://localhost:8888/home/board/write.jsp";
			//location.href = "/home/board/write.jsp";
			location.href = "<%=request.getContextPath()%>/board/write.jsp";
		});
	});
</script>

<div class="outbox center" style="width:800px">
	
	<div class="row">
		<h2>자유 게시판</h2>
	</div>
	
	<div class="row">
		글은 자신을 표현하는 마음의 거울입니다
	</div>
	
	<div class="row right">
		<button class="write-btn input input-inline">글쓰기</button>
	</div>
	
	<div class="row">
		<table class="table table-border table-pattern">
			<thead>
				<tr>
					<th>번호</th>
					<th width="45%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%for(BoardDto dto : list){ %>
				<tr>
					<td><%=dto.getBoard_no()%></td>
					<td class="left">
					
						<!-- 말머리는 없는 경우를 고려하여 조건으로 출력 -->
						<%if(dto.getBoard_header() != null){ %>
							[<%=dto.getBoard_header()%>]
						<%}%>

						<!-- 글 제목을 누르면 상세 페이지로 이동하도록 번호를 첨부하여 링크 설정 -->		
						<a href="detail.jsp?board_no=<%=dto.getBoard_no()%>">				
							<%=dto.getBoard_title()%>
						</a>
						
					</td>
					<td><%=dto.getBoard_writer()%></td>
					<td><%=dto.getBoard_time()%></td>
					<td><%=dto.getBoard_read()%></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	
	<div class="row right">
		<button class="write-btn input input-inline">글쓰기</button>
	</div>
	
	<!-- 검색창 -->
	<form action="list.jsp" method="post">
	<div class="row">
		<select name="type" class="input input-inline">
			<option value="board_title" <%if(type!=null&&type.equals("board_title")){%>selected<%}%>>제목</option>
			<option value="board_writer" <%if(type!=null&&type.equals("board_writer")){%>selected<%}%>>작성자</option>
		</select>
		<%if(isSearch){ %>
		<input type="text" class="input input-inline" name="key" required value="<%=key%>">
		<%}else{ %>
		<input type="text" class="input input-inline" name="key" required>
		<%} %>
		<input type="submit" class="input input-inline" value="검색">
	</div>
	</form>
	
	<!-- 페이지 네비게이션 -->
	<div class="row">
		<ul class="pagination">
			<li><a href="#">&lt;</a></li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>
			<li><a href="#">9</a></li>
			<li><a href="#">10</a></li>
			<li><a href="#">&gt;</a></li>
		</ul>
	</div>
	
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>