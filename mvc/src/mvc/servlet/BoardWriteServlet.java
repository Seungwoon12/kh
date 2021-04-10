package mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.BoardDao;
import mvc.beans.BoardDto;

//이 서블릿은 게시글 등록과 관련된 2가지 작업을 방식으로 구분하여 처리
//1. GET 방식으로 요청이 오면 "작성 페이지"로 포워드
//2. POST 방식으로 요청이 오면 "등록 페이지"로 포워드
//@WebServlet(urlPatterns = "/board/write.do")
public class BoardWriteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//포워드
			req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//데이터 받아서 등록
			req.setCharacterEncoding("UTF-8");
			BoardDto boardDto = new BoardDto();
			boardDto.setBoard_header(req.getParameter("board_header"));
			boardDto.setBoard_title(req.getParameter("board_title"));
			boardDto.setBoard_content(req.getParameter("board_content"));
			boardDto.setBoard_writer("admin");//작성자는 임의로 지어냄(DB에 있어야함)
			
			BoardDao boardDao = new BoardDao();
			int board_no = boardDao.getSequence();
			boardDto.setBoard_no(board_no);
			boardDao.writeWithPrimaryKey(boardDto);
			
			//리다이렉트
			resp.sendRedirect("detail.do?board_no="+board_no);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
