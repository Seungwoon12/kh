package home.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.util.StringUtil;

//여태까지 만든 기능 중 유일하게 서블릿이 먼저 나오고 데이터를 첨부해야 하는 상황
@WebServlet(urlPatterns = "/admin/pw.do")
public class AdminPasswordServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 회원번호를 받고 임시비밀번호를 생성
			int member_no = Integer.parseInt(req.getParameter("member_no"));
			
//			랜덤 문자열 생성
			String password = StringUtil.generateRandomString(10);
			
//			처리 : 비밀번호 변경처리
			MemberDao dao = new MemberDao();
			boolean result = dao.editPasswordByAdmin(member_no, password);
			
//			출력 : 변경된 비밀번호를 출력
			if(result) {
//				1. 리다이렉트에 파라미터를 추가하여 데이터를 전달하는 방법
//				= 리다이렉트는 사용자가 이 페이지를 떠나서 다시 들어오도록 하는 방식
//				= 전화로 치면 끊고 다시 연락주세요~ 라는 느낌
//				= 데이터 전달이 어렵고 노출됨
//				resp.sendRedirect("pw.jsp?password="+password);
				
//				2. 포워드(forward) 하는 방식
//				= 사용자의 연결을 유지한 채 다른 페이지로 전달하는 방식
//				= 전화로 치면 통화가 연결된 상태로 다른 부서로 전달되는 방식
//				= 뒷페이지는 앞페이지와 이어진다(합쳐서 한 페이지가 되는 효과가 발생)
//				= 데이터를 원하는 만큼 전달할 수 있다(req에 추가)
				req.setAttribute("password", password);//뒷페이지에서 사용할 데이터 추가(연결 종료 전까지만 사용)				
				req.getRequestDispatcher("pw.jsp").forward(req, resp);				
			}
			else {
				resp.sendError(404);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
