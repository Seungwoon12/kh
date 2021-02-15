<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="home.beans.*" %>
<%@ page import="java.util.*" %>

<jsp:include page="/template/header.jsp"></jsp:include>

<%
// 	이 페이지에서는 회원 목록은 보여주지 않고 검색만 진행
// 	검색에 필요한 값들을 파라미터로 전달받아야 합니다(유형 : type , 검색어 : key)
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	String key = request.getParameter("key");
	
	boolean isSearch = type != null && key != null;
	
// 	목록이 필요가 없으니 바로 검색 진행
	MemberDao dao = new MemberDao();
	List<MemberDto> list = dao.select(type, key);
	
// 	list의 상태가 총 3가지 발생할 수 있다.
// 	(1) list == null
//	(2) list.isEmpty() 또는 list.size() == 0
//	(3) !list.isEmpty() 또는 list.size() > 0
%>


<script>
	//.delete-link를 누르면 확인창 후 진행하도록 구현
	$(function(){
		$(".delete-link").click(function(e){
			e.preventDefault();//a, form태그는 기본 설정된 이벤트를 방지해야 합니다
			
			var choice = window.confirm("정말 회원탈퇴 진행하시겠습니까?");
			if(choice){
				//location.href = $(this).attr("href");
				$(location).attr("href", $(this).attr("href"));
			}
		});
	});
</script>

<div class="outbox" style="width:800px">
	<!-- 제목 -->
	<div class="row center">
		<h2>회원 검색</h2>
	</div>
	<!-- 검색 폼 -->
	<form action="list.jsp" method="get">
		<div class="row center">
			<select name="type" class="input input-inline" required>
				<option value="">분류 선택</option>
				<option value="member_no" <%if(type!=null&&type.equals("member_no")){%>selected<%}%>>번호</option>
				<option value="member_id" <%if(type!=null&&type.equals("member_id")){%>selected<%}%>>아이디</option>
				<option value="member_nick" <%if(type!=null&&type.equals("member_nick")){%>selected<%}%>>닉네임</option>
				<option value="member_birth" <%if(type!=null&&type.equals("member_birth")){%>selected<%}%>>생년월일</option>
				<option value="member_auth" <%if(type!=null&&type.equals("member_auth")){%>selected<%}%>>등급</option>
			</select>
			
			<%if(isSearch){ %>
			<input type="text" name="key" placeholder="검색어 입력" required class="input input-inline" value="<%=key%>">
			<%}else{ %>
			<input type="text" name="key" placeholder="검색어 입력" required class="input input-inline">
			<%} %>
			
			<input type="submit" value="검색" class="input input-inline">
		</div>
	</form>
	
	<!-- 결과 화면 : 검색결과가 있는 경우와 없는 경우로 구분하여 출력 -->
	
	<%if(list == null){ %>
	<!-- 처음 들어온 경우 보여줄 화면 -->
	<div class="row center">
		<h4>검색분류와 검색어를 입력해주세요</h4>
	</div>
	<%} else if (list.isEmpty()){ %>
	<!-- 검색 결과가 없는 경우의 화면 -->
	<div class="row center">
		<h4>검색 결과가 존재하지 않습니다</h4>
	</div>
	<%} else { %>
	<!-- 검색 결과가 있는 경우의 화면 -->
	<div class="row">
		<table class="table table-border table-pattern">
			<thead>
				<tr>
					<th>회원번호</th>
					<th>아이디</th>
					<th>닉네임</th>
					<th>생년월일</th>
					<th>등급</th>
					<th>관리메뉴</th>
				</tr>
			</thead>
			<tbody>
				<!-- 데이터 개수만큼 줄을 반복하며 출력 -->
				<%for(MemberDto dto : list){ %>
				<tr>
					<td><%=dto.getMember_no()%></td>
					<td><%=dto.getMember_id()%></td>
					<td><%=dto.getMember_nick()%></td>
					<td><%=dto.getMember_birth()%></td>
					<td><%=dto.getMember_auth()%></td>
					<td>
						<a href="detail.jsp?member_no=<%=dto.getMember_no()%>">상세</a>
						<a href="pw.do?member_no=<%=dto.getMember_no()%>">임시</a>
						<a href="edit.jsp?member_no=<%=dto.getMember_no()%>">수정</a>
						<a class="delete-link" href="delete.do?member_no=<%=dto.getMember_no()%>">탈퇴</a>
					</td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<%} %>
	
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>
