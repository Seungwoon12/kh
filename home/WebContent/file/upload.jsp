<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	파일 업로드 화면
	1. 파일 전송을 하려면 input[type=file] 태그가 필요하다. 
	2. 파일은 POST방식으로 전송해야 한다.
	- form은 기본적으로 application/x-www-form-urlencoded 방식으로 데이터를 전송하게 되어 있다.
	- 이 방식에서는 key=value가 세트로 연결되어 전송되므로 이름 하나에 하나만 데이터를 전달할 수 있다.
	- 파일처럼 하나의 이름에 다양한 정보를 보내야 하는 상황이라면 multipart/form-data 방식을 사용해야 한다.
	- 이렇게 되면 요청 자체가 변경되어 버리므로, 기존 방식으로는 요청을 분석할 수 없다.
	- 따라서, multipart 방식의 요청을 전문적으로 분석하는 라이브러리를 사용해서 서블릿에서 수신을 해야한다.
-->

<h1>전송화면</h1>
<form action="receive.do" method="post" enctype="multipart/form-data">

	<input type="text" name="id">
	<br><br>
	<input type="file" name="f" accept=".jpg , .png , .gif">
	<br><br>
	<input type="submit" value="업로드">
	
</form>