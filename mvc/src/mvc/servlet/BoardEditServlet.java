package mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.BoardDao;
import mvc.beans.BoardDto;

//@WebServlet(urlPatterns = "/board/edit.do")
public class BoardEditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//처리
			int board_no = Integer.parseInt(req.getParameter("board_no"));
			
			BoardDao boardDao = new BoardDao();
			BoardDto boardDto = boardDao.find(board_no);
			
			req.setAttribute("boardDto", boardDto);
			
			//포워드
			req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp").forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			BoardDto boardDto = new BoardDto();
			boardDto.setBoard_no(Integer.parseInt(req.getParameter("board_no")));
			boardDto.setBoard_header(req.getParameter("board_header"));
			boardDto.setBoard_title(req.getParameter("board_title"));
			boardDto.setBoard_content(req.getParameter("board_content"));
			
			BoardDao boardDao = new BoardDao();
			boardDao.update(boardDto);
			
			resp.sendRedirect("detail.do?board_no="+boardDto.getBoard_no());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}