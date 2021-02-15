package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.ReplyDao;
import home.beans.ReplyDto;

/**
 * 댓글 수정 서블릿
 */
@WebServlet(urlPatterns = "/board/reply_edit.do")
public class ReplyEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 글번호(reply_origin) , 글내용(reply_content)
			req.setCharacterEncoding("UTF-8");
			ReplyDto replyDto = new ReplyDto();
			replyDto.setReply_no(Integer.parseInt(req.getParameter("reply_no")));
			replyDto.setReply_origin(Integer.parseInt(req.getParameter("reply_origin")));
			replyDto.setReply_content(req.getParameter("reply_content"));
			
//			계산 : 수정
			ReplyDao replyDao = new ReplyDao();
			replyDao.update(replyDto);
			
//			출력 : detail.jsp로 복귀
			resp.sendRedirect("detail.jsp?board_no="+replyDto.getReply_origin());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
