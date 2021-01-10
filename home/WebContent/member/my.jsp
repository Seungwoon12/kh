<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="home.beans.MemberDao"%>
<%@page import="home.beans.MemberDto"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<%
	//세션에 회원번호가 저장되어 있습니다
	//이 페이지에서는 회원의 모든 정보를 출력해야 하기 때문에 데이터베이스를 조회하여 모든 정보를 불러와서 출력해야 합니다
	//필요한 코드를 구현하여 정보를 가져오고, 표현식을 이용해 화면에 출력해보세요
	//(hint) 세션에 저장되는 데이터의 형태는 Object입니다. 
	int member_no = (int)session.getAttribute("check");
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
		<a href="pw.jsp">비밀번호 변경하기</a>
	</div>
	<div class="row center">
		<a href="edit.jsp">정보 변경하기</a>
	</div>
	<div class="row center">
		<a href="delete.do">회원 탈퇴하기</a>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>