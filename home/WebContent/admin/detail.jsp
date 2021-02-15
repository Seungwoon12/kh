<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="home.beans.MemberDao"%>
<%@page import="home.beans.MemberDto"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<%
	//이 페이지는 관리자가 회원의 상세정보를 보기 위한 페이지입니다.
	//회원의 내정보 페이지와의 차이점은 "회원번호"를 어디서 가져오느냐의 차이입니다.
	//= 파라미터를 통해 보고싶은 회원의 번호를 전달받아 조회하도록 구현
	int member_no = Integer.parseInt(request.getParameter("member_no"));
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.find(member_no); 
%>


<div class="outbox" style="width:400px">
	<div class="row center">
		<h2>회원 정보</h2>
	</div>
	<div class="row">
		<table class="table table-border">
			<tbody>
				<tr>
					<th width="25%">번호</th>
					<td><%=dto.getMember_no()%></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><%=dto.getMember_id()%></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><%=dto.getMember_nick()%></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><%=dto.getMember_birth()%></td>
				</tr>
				<tr>
					<th>권한</th>
					<td><%=dto.getMember_auth()%></td>
				</tr>
				<tr>
					<th>포인트</th>
					<td><%=dto.getMember_point()%></td>
				</tr>
				<tr>
					<th>가입일</th>
					<td><%=dto.getMember_join()%></td>
				</tr>
			</tbody> 
		</table>
	</div>
	
	<!-- 각종메뉴 -->
	<div class="row center">
		<a href="list.jsp">목록으로 돌아가기</a>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>