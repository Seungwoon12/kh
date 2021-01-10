package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardDao;
import beans.BoardDto;

//게시글 수정 처리 서블릿
//1. 입력페이지에서 전달되는 데이터를 수신
//2. Database에서 수정 쿼리를 실행
//3. 수정 완료 화면으로 이동
@WebServlet(urlPatterns = "/board/edit.do")
public class BoardEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			BoardDto dto = new BoardDto();
			dto.setBoard_no(Integer.parseInt(req.getParameter("board_no")));
			dto.setBoard_header(req.getParameter("board_header"));
			dto.setBoard_title(req.getParameter("board_title"));
			dto.setBoard_content(req.getParameter("board_content"));
			
			BoardDao dao = new BoardDao();
			boolean result = dao.update(dto); 
			
			//성공/실패 여부에 따라 다른 결과 페이지로 이동
			//- 성공 시 상세 페이지로 이동(반드시 번호를 전달해야함)
			//- 실패 시 에러 페이지로 이동
			if(result) {
				//resp.sendRedirect("edit_success.jsp");
				resp.sendRedirect("detail.jsp?board_no="+dto.getBoard_no());
			}
			else {
				resp.sendRedirect("edit_fail.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
