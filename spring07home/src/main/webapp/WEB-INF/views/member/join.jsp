<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>		
			
<form action="join.do" method="post">
	<div class="outbox" style="width:500px">
		<div class="row center">
			<h2>회원 정보 입력</h2>
		</div>
		<div class="row">
			<label>ID</label>
			<input type="text" name="member_id" required class="input" placeholder="8~20자 영문 소문자/숫자">
		</div>
		<div class="row">
			<label>Password</label>
			<input type="password" name="member_pw" required class="input" placeholder="8~20자 영문 소문자/대문자/특수문자/숫자">
		</div>
		<div class="row">
			<label>Nickname</label>
			<input type="text" name="member_nick" required class="input" placeholder="한글 2~10자">
		</div>
		<div class="row">
			<label>Birth</label>
			<input type="date" name="member_birth" required class="input">
		</div>
		<div class="row">
			<input type="submit" value="회원가입" class="input">
		</div>
	</div>
</form>
			
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>	