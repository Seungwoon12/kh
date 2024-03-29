<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//세션에 있는 회원번호(내 번호)를 이용하여 정보를 불러와 화면에 출력
	int member_no = (int)session.getAttribute("check");
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.find(member_no);
%>    
    
<jsp:include page="/template/header.jsp"></jsp:include>

<form action="edit.do" method="post">
	<div class="outbox" style="width:500px">
		<div class="row center">
			<h2>회원 정보 수정</h2>
		</div>
		<div class="row">
			<label>Nickname</label>
			<input type="text" name="member_nick" required class="input" 
						placeholder="한글 2~10자" value="<%=dto.getMember_nick()%>">
		</div>
		<div class="row">
			<label>Birth</label>
			<input type="date" name="member_birth" required 
						class="input" value="<%=dto.getMember_birth()%>">
		</div>
		<div class="row">
			<label>비밀번호를 한 번 더 입력하세요</label>
			<input type="password" name="member_pw" required class="input" placeholder="8~20자 영문 소문자/대문자/특수문자/숫자">
		</div>
		<div class="row">
			<input type="submit" value="정보수정" class="input">
		</div>
		
		<%if(request.getParameter("error") != null){ %>
		<div class="row" style="color:red;">
			현재 비밀번호가 일치하지 않습니다
		</div>
		<%}else if(request.getParameter("nick") != null){ %>
		<div class="row" style="color:red;">
			동일한 닉네임이 존재합니다.
		</div>
		<%} %>
	</div>
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>