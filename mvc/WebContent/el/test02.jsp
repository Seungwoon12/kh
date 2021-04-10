<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL을 이용하면 복잡하던 자바코드를 간소화시킬 수 있다.
	= EL은 "출력용 뷰 페이지"에 특화되어 있기 때문에 웹에서 사용하는 데이터들을 쉽게 접근하도록 내장객체를 만들어놨다
	
	특징
	= param이라는 내장객체를 이용하면 파라미터에 쉽게 접근할 수 있다.
	= 값이 null일 경우 화면에 출력하지 않는다.
	= 객체도 연산자로 비교하게 해준다.
	= 문자열을 외따옴표로 표기해도 처리해준다.
--%>

<h1>key = <%=request.getParameter("key")%></h1>
<h1>key = ${param.key}</h1>

<h1>music? <%=request.getParameter("key") == "music"%></h1>
<h1>music? <%=request.getParameter("key").equals("music")%></h1>
<h1>music? ${param.key == 'music'}</h1>