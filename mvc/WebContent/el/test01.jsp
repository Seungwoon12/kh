<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	EL (Expression Language, 표현 언어)
	= 포워딩 구조에서 출력을 간소화 시키기 위해 나온 구문
	= 형태는 ${값} 과 같이 사용한다
	= 기본적인 사용 구조는 표현식(Expression)과 유사하다
	= 표현식보다 짧고, 간결하고, 편리하게 구성하려고 노력했다
	
	차이점
	= 나눗셈이 일반적인 나눗셈으로 나온다
	= EL에서는 단어형 연산이 지원되는 것들이 있다(ex : div, mod, eq, ne, gt, lt, not, empty, ...)
	= EL에서는 변수 등을 생성할 수 없다(만들어진것을 이용할 수만 있다)
	= EL에서는 객체 생성이 어렵다
--%>

100 + 200 : <%=100 + 200%> , ${100 + 200}
<hr>
100 * 200 : <%=100 * 200%> , ${100 * 200}
<hr>
<%-- 100 / 200 : <%=100 / 200%> , ${100 / 200} , ${100 div 200}--%>
<hr>
100 % 200 : <%=100 % 200%> , ${100 % 200} , ${100 mod 200}
<hr>
100 == 200 : <%=100 == 200%> , ${100 == 200} , ${100 eq 200}
