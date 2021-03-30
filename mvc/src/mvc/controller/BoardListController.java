package mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.beans.BoardDao;
import mvc.beans.BoardDto;

//게시글 목록에 필요한 작업을 수행한 뒤 서블릿에게 연결될 주소를 반환
public class BoardListController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BoardDao boardDao = new BoardDao();
		List<BoardDto> list = boardDao.select();
		
		req.setAttribute("list", list);
		
		return "/WEB-INF/views/board/list.jsp";
	}
	
}