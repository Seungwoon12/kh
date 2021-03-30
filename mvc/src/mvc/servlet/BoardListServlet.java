package mvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.BoardDao;
import mvc.beans.BoardDto;

//게시판 목록을 보여주기 위한 프로그래밍 처리를 수행
//@WebServlet(urlPatterns = "/board/list.do")
public class BoardListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String type = req.getParameter("type");
			String key = req.getParameter("key");
			
			BoardDao boardDao = new BoardDao();
			List<BoardDto> list = boardDao.select();
			
			req.setAttribute("list", list);
			
			//포워드
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}