<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="home.beans.*" %>
<%@ page import="java.util.*" %>
<%
	//포인트 보유량이 많은 순으로 1위부터 3위까지 조회하는 페이지
	//= MemberDao를 이용하여 조회
	//= 결과가 MemberDto만으로는 표현하기 부족하다(+rank 정보가 추가될 공간이 없다)
	//= 상황에 맞게 별도의 VO(DTO)를 생성하여 정보를 보관하도록 코드를 구성한다 
	
	MemberDao dao = new MemberDao();
	List<MemberRankVO> list = dao.getPointRank(1, 3); 
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div class="outbox center" style="width:500px">
	<div class="row">
		<h2>포인트 랭킹 Top 3</h2>
	</div>
	<div class="row">
		<table class="table table-border table-highlight">
			<thead>
				<tr>
					<th>순위</th>
					<th>아이디</th>
					<th>포인트</th>
				</tr>
			</thead>
			<tbody>
				<%for(MemberRankVO vo : list){ %>
				<tr>
					<td><%=vo.getRank()%></td>
					<td>
						<a href="detail.jsp?member_no=<%=vo.getMember_no()%>">
							<%=vo.getMember_id()%>
						</a>
					</td>
					<td><%=vo.getMember_point()%></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>
