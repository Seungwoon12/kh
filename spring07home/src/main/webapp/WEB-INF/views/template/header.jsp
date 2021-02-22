<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	템플릿 페이지는 자체적으로 실행되는 것이 아니라 특정 페이지에 붙어서 실행된다.
	따라서 작성되는 경로의 기준점이 이 페이지가 아니라 붙어서 실행되는 대상 페이지가 된다.
	
	상대경로를 사용하면 오류의 발생 가능성이 매우 높다(경로가 다양하기 때문에)
	= 절대경로를 사용하면 다양한 경로와 관계없이 동일한 위치를 가리키게 된다
	= 절대경로를 사용할 때 context path를 직접 입력하면 변화에 대처가 어렵다
	= request 객체를 이용하여 context path를 구해올 수 있다
	= request.getContextPath()
	= /home 형태로 최상위 경로가 구해진다
 -->
 
<%
	//사용자가 로그인 상태인지 계산하는 코드
	//로그인 상태 : session 에 check 라는 이름의 값이 존재할 경우(null이 아닌 경우)
	//로그아웃 상태 : session 에 check 라는 이름의 값이 존재하지 않을 경우(null인 경우)
	boolean isLogin = session.getAttribute("check") != null;
	
	boolean isAdmin = isLogin && session.getAttribute("auth").equals("관리자");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가만든 홈페이지</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<style>
	/* 화면 레이아웃 스타일 */
	
	/* 모든 영역은 점선으로 테두리가 표시되게 한다(테스트용) */
	main, header, nav, section, 
	aside, article, footer, div,
	label, span, p {
		border: 1px dotted #ccc;
	}
	
	/* 전체 화면의 폭은 1024px 로 한다 */
	main {
		width:1024px;
		margin:auto;
	}
	
	/* 각각의 레이아웃 영역에 여백을 설정한다 */
	header, footer, nav, section {
		padding:1rem;
	}
	
	/* 본문에 내용이 없어도 최소높이를 설정하여 일정 크기만큼 표시되도록 한다 */
	section {
		min-height: 450px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
</script> 
</head>
<body>
	<main>
		<header>
			<h1 class="center">JSP로 홈페이지 만들기</h1>
		</header>
		<nav>
			<%if(!isLogin){ %>
			<!-- 비회원이 마주할 메뉴 -->
			<a href="<%=request.getContextPath()%>/home/index">홈으로</a>
			<a href="<%=request.getContextPath()%>/member/join.jsp">회원가입</a>
			<a href="<%=request.getContextPath()%>/member/login.jsp">로그인</a>
			<a href="<%=request.getContextPath()%>/board/list.jsp">게시판</a>
			<%}else{ %>
			<!-- 회원이 마주할 메뉴 -->
			<a href="<%=request.getContextPath()%>">홈으로</a>
			<a href="<%=request.getContextPath()%>/member/logout.do">로그아웃</a>
			<a href="<%=request.getContextPath()%>/member/my.jsp">내정보</a>
			<a href="<%=request.getContextPath()%>/board/list.jsp">게시판</a>
			<%} %>
			<%if(isAdmin) {%>
			<a href="<%=request.getContextPath()%>/admin/home.jsp">관리메뉴</a>
			<%} %>
		</nav>
		<section>