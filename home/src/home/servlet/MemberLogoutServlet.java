package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	로그아웃을 처리하는 서블릿
 *	= 로그아웃은 세션에 들어있는 check라는 이름의 데이터를 삭제하는 작업이다
 *	= 로그아웃은 데이터베이스와 전혀 상관이 없는 작업이다 
 */
@WebServlet(urlPatterns = "/member/logout.do")
public class MemberLogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			서블릿에서는 session 대신 req.getSession() 을 이용하여 세션에 접근한다
			req.getSession().removeAttribute("check");//check값을 삭제하라
			req.getSession().removeAttribute("auth");//auth값을 삭제하라
//			req.getSession().invalidate();//세션을 파괴하라!
			
//			resp.sendRedirect("../index.jsp");//상대경로
			resp.sendRedirect(req.getContextPath()+"/index.jsp");//root로 이동(절대경로)
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}