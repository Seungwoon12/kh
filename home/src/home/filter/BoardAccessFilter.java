package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;
import home.beans.MemberDao;
import home.beans.MemberDto;

/**
 *	게시글 수정, 삭제 시 본인이나 관리자만 접근이 가능하도록 검사하여 차단하는 필터 
 */
@WebFilter(urlPatterns = {
	"/board/edit.jsp", "/board/edit.do",
	"/board/delete.do"
})
public class BoardAccessFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//필터라면 있어야 하는 두 줄
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding("UTF-8");
		HttpServletResponse resp = (HttpServletResponse)response;
		
		try {
//			준비 : 게시글번호, 세션의 회원번호, 세션의 권한
//			계산 : 관리자인지 검증 -> 본인인지 검증
//			처리 : 요건 충족시 통과 , 아니면 403 오류 송출
			
//			관리자라면 통과
			String auth = (String)req.getSession().getAttribute("auth");
			if(auth != null && auth.equals("관리자")) {
				chain.doFilter(request, response);
				return;
			}
			
//			본인이라면 통과
			int board_no = Integer.parseInt(req.getParameter("board_no"));
			BoardDao boardDao = new BoardDao();
			BoardDto boardDto = boardDao.find(board_no);
			
			int member_no = (int)req.getSession().getAttribute("check");
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.find(member_no);
			
			if(memberDto.getMember_id().equals(boardDto.getBoard_writer())) {
				chain.doFilter(request, response);
				return;
			}
			
//			위에서 통과되지 못한 경우 403 오류 송출
			resp.sendError(403);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}