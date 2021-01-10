package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardDao;

@WebServlet(urlPatterns = "/board/delete.do")
public class BoardDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int board_no = Integer.parseInt(req.getParameter("board_no"));
			
			BoardDao dao = new BoardDao();
			boolean result = dao.delete(board_no);
			
			if(result) {
//				resp.sendRedirect("delete_success.jsp");
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
