<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSTL(Jsp Standard Tag Library, JSP 표준 태그 모음)
	- JSP에서 어쩔 수 없이 화면 출력을 위해 필요한 자바 코드들을 태그로 만들어놓은 라이브러리
	- 총 5가지 종류가 있음(core, format, function, sql, xml)
	- core : 프로그래밍 필수 구문들을 태그화 시킨 모듈
	- format : 형식 변경 구문들을 태그화 시킨 모듈
	- function : 문자열 계산 작업을 태그화 시킨 모듈
	- sql : 데이터베이스 연동을 태그화 시킨 모듈(안씀)
	- xml : xml 해석을 태그화 시킨 모듈(안씀)
	
	- 사용하기 위해서는 JSTL 라이브러리(.jar)가 필요
	- 사용할 태그의 모듈을 페이지에 명시해야 한다
--%>

<%-- core 태그 모듈 사용 설정 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	core 태그 모듈의 주요 기능
	- 변수 생성, 호출, 제거
	- 조건 구문
	- 반복 구문
	- 예외 처리
	- 주소 설정 등
--%>

<c:set var="a" value="10"></c:set>

<h1>a = ${a}</h1>

<c:set var="a" value="${a+5}"></c:set>

<h1>a = ${a}</h1>

<c:set var="a" value="hello"></c:set>

<h1>a = ${a}</h1>

<c:remove var="a"/>

<h1>a = ${a}</h1>
