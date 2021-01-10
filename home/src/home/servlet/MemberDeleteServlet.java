package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

@WebServlet(urlPatterns = "/member/delete.do")
public class MemberDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 파라미터가 아니라 세션에 들어있는 회원번호를 가져와야 한다
			int member_no = (int) req.getSession().getAttribute("check");
			
//			처리 : 회원탈퇴 처리 + 로그아웃 처리
			MemberDao dao = new MemberDao();
			dao.delete(member_no);
			
			req.getSession().removeAttribute("check");
			
//			결과 : 탈퇴완료 페이지(goodbye.jsp)로 리다이렉트
//			= 세션에 들어있는 회원번호로 삭제하는데 실패할리가 있나~ 고려하지 않는다!
			resp.sendRedirect("goodbye.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}