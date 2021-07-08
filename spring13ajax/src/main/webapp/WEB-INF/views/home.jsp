<%@ page contentType="text/html; charset=UTF-8" %>

<!-- 
	(주의) jquery 중에서 slim이 들어간 버전에는 비동기 통신 기능이 없다
 -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	//목표 : 아이디 입력창에 입력이 완료되면 서버로 비동기통신을 보내서 아이디가 존재하는지 여부를 확인하겠다!
	//- 서버의 주소 : http://localhost:8888/spring13/async/idcheck
	//- 서버의 준비물 : member_id
	//- 서버의 결과물 : String(NNNNN 또는 NNNNY)
	
	$(function(){
		$("input[name=member_id]").blur(function(){
			
			//입력값
			var member_id = $(this).val();
			
			//비동기 통신 코드
			// - url : 통신할 서버의 주소
			// - type : 통신할 방식
			// - data : 전송할 데이터
			$.ajax({
				url : "${pageContext.request.contextPath}/async/idcheck",
				type : "get", 
				data : {
					member_id : member_id
				},
				success : function(resp){
					if(resp == "NNNNY"){//사용가능
						$("input[name=member_id]").next("span").text("사용가능!");
					}
					else if(resp == "NNNNN"){//사용불가
						$("input[name=member_id]").next("span").text("사용불가!");
					}
				}
			});
			
		});
		
		//버튼을 누르면 목록을 불러온다.
		$("button").click(function(){
			$.ajax({
				url : "${pageContext.request.contextPath}/async/list",
				type : "get", 
				success : function(resp){//resp == 목록
					//console.log(resp);
					resp = $.parseJSON(resp);//JSON 복원
					$.each(resp, function(){
						console.log(this);
					});
				}
			});
		});
	});
</script>

<h1>비동기 통신 예제</h1>

<p>회원 가입 시 아이디/닉네임 검사 진행</p>

<form action="join" method="post">

	<!-- 입력창들 -->
	<label>
		아이디 :
		<input type="text" name="member_id">
		<span></span>
	</label>
	<br><br>
	
	<label>
		닉네임 :
		<input type="text" name="member_nick">
		<span></span> 
	</label>
	<br><br>
	
	<!-- 전송버튼 -->
	<input type="submit" value="가입">

</form>

<hr>

<button>목록보기</button>

<div id="list"></div>
