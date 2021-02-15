package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;
import home.beans.ReplyDao;
import home.beans.ReplyDto;

@WebServlet(urlPatterns = "/board/reply_insert.do")
public class ReplyInsertServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 파라미터(내용,원본글번호) + 세션(사용자정보)
			req.setCharacterEncoding("UTF-8");
			ReplyDto replyDto = new ReplyDto();
			replyDto.setReply_content(req.getParameter("reply_content"));
			replyDto.setReply_origin(Integer.parseInt(req.getParameter("reply_origin")));
			
			int member_no = (int)req.getSession().getAttribute("check");
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.find(member_no);
			
			replyDto.setReply_writer(memberDto.getMember_id());
			
//			계산 : 댓글 테이블에 등록
			ReplyDao replyDao = new ReplyDao();
			replyDao.insert(replyDto);
			 
//			출력 : 상세보기 글로 다시 돌아가도록 처리
			resp.sendRedirect("detail.jsp?board_no="+replyDto.getReply_origin());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
