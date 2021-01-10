package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MemberDao;
import beans.MemberDto;

@WebServlet(urlPatterns = "/member/join.do")
public class JoinServlet extends HttpServlet{
//	POST 방식의 요청만 받는 처리 메소드(다른 방식은 접근 불가)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		앞으로의 서블릿은 try~catch로 전체를 감싼 뒤, 예외가 발생하면 사용자에게 알림 + 에러 로그 출력
		try {
//			수신(준비)
			req.setCharacterEncoding("UTF-8");//한글 복구 작업
			MemberDto dto = new MemberDto();
			dto.setMember_id(req.getParameter("member_id"));
			dto.setMember_pw(req.getParameter("member_pw"));
			dto.setMember_nick(req.getParameter("member_nick"));
			dto.setMember_birth(req.getParameter("member_birth"));
			
			MemberDao dao = new MemberDao();
			dao.insert(dto);
			
			resp.sendRedirect("join_success.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();//에러 로그 출력
			resp.sendError(500);//사용자에게 오류가 발생했음을 알려준다(500)
//			resp.sendError(HttpURLConnection.HTTP_INTERNAL_ERROR);//상수값으로 적용
		}
	}
}
