<%@page import="java.util.ArrayList"%>
<%@page import="mvc.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	List<DTO> 형태의 저장소가 있을 때 JSTL 반복 태그를 이용하여 화면에 출력
	- varStatus 속성을 이용하면 확장 반복문을 사용할 때 알기 어려운 순서, 처음/마지막 여부를 파악할 수 있다.
		- index : 반복 순서(0부터 시작)
		- count : 현재까지 출력한 개수(1부터 시작)
		- first : 처음인지 아닌지 true/false로 알려줌
		- last : 마지막인지 아닌지 true/false로 알려줌
--%>

<%
	//서블릿에서 작성한다고 가정하고 저장소를 만들어 데이터를 등록
	List<Student> list = new ArrayList<>();
	
	Student a = new Student();
	a.setName("피카츄");
	a.setScore(99);
	
	Student b = new Student();
	b.setName("라이츄");
	b.setScore(90);
	
	Student c = new Student();
	c.setName("꼬부기");
	c.setScore(85);
	
	list.add(a);
	list.add(b);
	list.add(c);
	
	request.setAttribute("list", list);
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="stu" items="${list}">
	<h3>이름 : ${stu.name}</h3>
	<h3>점수 : ${stu.score}</h3>
</c:forEach>

<hr>

<c:forEach var="stu" items="${list}" varStatus="status">
	<h3>index : ${status.index}</h3>
	<h3>count : ${status.count}</h3>
	<h3>first : ${status.first}</h3>
	<h3>last : ${status.last}</h3>
	<h3>이름 : ${stu.name}</h3>
	<h3>점수 : ${stu.score}</h3>
</c:forEach> 