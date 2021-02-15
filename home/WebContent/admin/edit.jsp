  
<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//관리자가 "회원"을 수정하는 것이므로, 회원 번호를 세션이 아닌 파라미터로 전달받아서 조회 결과를 출력해줘야 한다
	int member_no = Integer.parseInt(request.getParameter("member_no"));
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.find(member_no);
%>    
    
<jsp:include page="/template/header.jsp"></jsp:include>

<form action="edit.do" method="post">
	<!-- 회원번호는 표시하진 않지만 전송은 하도록 구현 -->
	<input type="hidden" name="member_no" value="<%=dto.getMember_no()%>">

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
			<label>Point</label>
			<input type="number" name="member_point" required
						class="input" value="<%=dto.getMember_point()%>">
		</div>
		
		<div class="row">
			<label>auth</label>
			<select name="member_auth" class="input"> 
				<option <%if(dto.is("일반")){%>selected<%}%>>일반</option>
				<option <%if(dto.is("VIP")){%>selected<%}%>>VIP</option>
				<option <%if(dto.is("관리자")){%>selected<%}%>>관리자</option>
			</select>
		</div>
		
		<div class="row">
			<input type="submit" value="정보수정" class="input">
		</div>
		
		<div class="row center">
			<a href="list.jsp">목록으로 돌아가기</a>
		</div>
		
	</div>
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>