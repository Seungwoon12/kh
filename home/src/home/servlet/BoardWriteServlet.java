package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;
import home.beans.MemberDao;
import home.beans.MemberDto;

/**
 * 게시글 작성 서블릿
 * = 등록한 글의 번호를 무조건 알아내야 한다
 */
@WebServlet(urlPatterns = "/board/write.do")
public class BoardWriteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : board_header, board_title, board_content, board_writer
//			= 3개는 파라미터(board_header, board_title, board_content)에서 가져올 수 있다.
//			= 1개는 세션의 정보를 이용하여 구해야 한다(member_no -> board_writer)
			req.setCharacterEncoding("UTF-8");
			BoardDto boardDto = new BoardDto();
			boardDto.setBoard_header(req.getParameter("board_header"));
			boardDto.setBoard_title(req.getParameter("board_title"));
			boardDto.setBoard_content(req.getParameter("board_content"));
			
//			현재 로그인한 사용자 정보를 불러오는 코드
			int member_no = (int)req.getSession().getAttribute("check");
			MemberDao memberDao = new MemberDao();
			MemberDto memberDto = memberDao.find(member_no);
			
//			memberDto의 member_id를 boardDto의 board_writer에 설정
			boardDto.setBoard_writer(memberDto.getMember_id());
			
//			처리 : BoardDao를 사용
//			1. 시퀀스 번호 생성 - .getSequence()
//			2. 등록 - .writeWithPrimaryKey()
			BoardDao boardDao = new BoardDao();
			int board_no = boardDao.getSequence();	//시퀀스번호생성
			boardDto.setBoard_no(board_no);			//생성된 번호를 DTO에 설정
			boardDao.writeWithPrimaryKey(boardDto);	//설정된 정보를 등록!
			
//			출력
			resp.sendRedirect("detail.jsp?board_no="+board_no);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
