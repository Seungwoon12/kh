<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.*" %>
<%
	//데이터를 불러오는 코드(데이터베이스에서 select를 수행하기 위한 준비 코드를 작성)
	//1. 파라미터 수신
	String type = request.getParameter("type");//type이란 이름의 파라미터 값 불러오기(없으면 null)
	String key = request.getParameter("key");//key란 이름의 파라미터 값 불러오기(없으면 null)
	
	//2. 목록인지 검색인지 판정
	//boolean isSearch = 검색유형과 검색어 모두 있는 경우;
	boolean isSearch = type != null && key != null;
	
	//3. 목록 또는 검색결과를 조회
	MemberDao dao = new MemberDao();
	//List<MemberDto> list = dao.select() 또는 dao.select(type, key);
	List<MemberDto> list;
	if(isSearch){
		list = dao.select(type, key); 
	}
	else{
		list = dao.select();
	}
%>    


<!-- 제목 -->
<h1>회원 검색</h1>

<!-- 검색창 -->
<form action="list3.jsp" method="get">
	<!-- 검색유형 -->
	<select name="type">
		<option value="member_id">아이디</option>
		<option value="member_nick">닉네임</option>
		<option value="member_auth">권한</option>
	</select>
	<!-- 검색어 -->
	<%if(isSearch){ %>
	<input type="search" name="key" placeholder="검색어 입력" value="<%=key%>" required>
	<%} else{ %>
	<input type="search" name="key" placeholder="검색어 입력" required>
	<%} %>
	<!-- 전송버튼 -->
	<input type="submit" value="검색">
</form>

<hr>

<!-- 테이블 -->
<table border="1">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>닉네임</th>
			<th>생년월일</th>
			<th>권한</th>
			<th>포인트</th>
			<th>가입일</th>
		</tr>
	</thead>
	<tbody>
		<%for(MemberDto dto : list){ %>
		<tr>
			<td><%=dto.getMember_no()%></td>
			<td>
				<a href="detail.jsp?member_no=<%=dto.getMember_no()%>">
					<%=dto.getMember_id()%>
				</a>
			</td>
			<td><%=dto.getMember_nick()%></td>
			<td><%=dto.getMember_birth()%></td>
			<td><%=dto.getMember_auth() %></td>
			<td><%=dto.getMember_point()%></td>
			<td><%=dto.getMember_join()%></td>
		</tr>
		<%} %>
	</tbody>
</table>