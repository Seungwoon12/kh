package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;

@WebServlet(urlPatterns = "/board/delete.do")
public class BoardDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 번호가 필요
			int board_no = Integer.parseInt(req.getParameter("board_no"));
			
//			처리 : 삭제 처리
			BoardDao boardDao = new BoardDao();
			boardDao.delete(board_no);
			
//			출력 : 목록으로 이동
//			resp.sendRedirect("list.jsp");
			resp.sendRedirect(req.getContextPath()+"/board/list.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}