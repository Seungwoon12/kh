package mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.BoardDao;
import mvc.beans.BoardDto;

//@WebServlet(urlPatterns = "/board/detail.do")
public class BoardDetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//처리
			int board_no = Integer.parseInt(req.getParameter("board_no"));
			
			BoardDao boardDao = new BoardDao();
			BoardDto boardDto = boardDao.find(board_no);
			
			//첨부
			req.setAttribute("boardDto", boardDto);
			
			//포워드
			req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}