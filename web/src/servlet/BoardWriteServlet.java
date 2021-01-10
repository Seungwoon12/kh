package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardDao;
import beans.BoardDto;

@WebServlet(urlPatterns = "/board/write.do")
public class BoardWriteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : 파라미터
			req.setCharacterEncoding("UTF-8");
			BoardDto dto = new BoardDto();
			dto.setBoard_writer(req.getParameter("board_writer"));
			dto.setBoard_header(req.getParameter("board_header"));
			dto.setBoard_title(req.getParameter("board_title"));
			dto.setBoard_content(req.getParameter("board_content"));
			//처리
			BoardDao dao = new BoardDao();
			dao.write(dto);
			//출력 : 다른 페이지로 강제 이동, 재접속 지시(redirect) - 2번 사용하면 에러 발생
			//resp.sendRedirect("write_result.html");//상대경로
			//resp.sendRedirect("/web/board/write_result.html");//절대경로
			int no = dao.newNo(); 
			
			resp.sendRedirect("detail.jsp?board_no="+no);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}