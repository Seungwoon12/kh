package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;

@WebServlet(urlPatterns = "/member/delete.do")
public class MemberDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int member_no = Integer.parseInt(req.getParameter("member_no"));
			
			MemberDao dao = new MemberDao();
			boolean result = dao.delete(member_no);
			
			if(result) {
				resp.sendRedirect("list3.jsp");
			}
			else {
				resp.sendRedirect("delete_fail.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
