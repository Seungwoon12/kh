package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.BoardDao;
import mvc.beans.BoardDto;

//게시글 상세보기에 필요한 작업 수행 후 연결될 JSP 주소 반환
public class BoardDetailController implements Controller{
	
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int board_no = Integer.parseInt(req.getParameter("board_no"));
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = boardDao.find(board_no);
		
		req.setAttribute("boardDto", boardDto);

		return "/WEB-INF/views/board/detail.jsp";
	}
	
}