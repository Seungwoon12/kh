package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

//@WebServlet(urlPatterns = "/member/login.do")
public class MemberLoginServlet2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			1. 정보 수신
			req.setCharacterEncoding("UTF-8");
			MemberDto dto = new MemberDto();
			dto.setMember_id(req.getParameter("member_id"));
			dto.setMember_pw(req.getParameter("member_pw"));
			
//			2. 데이터베이스 조회
//			- find를 이용하는 방법
			MemberDao dao = new MemberDao();
			MemberDto result = dao.find(dto.getMember_id());
//			result는 객체이거나 null이다. null일 때는 사용이 불가하다.
			boolean login;
			if(result != null) {//아이디에 해당하는 정보가 있을 경우 --> 비밀번호 비교
//				dto와 result의 비밀번호를 비교
				login = dto.getMember_pw().equals(result.getMember_pw());
//				if(dto.getMember_pw().equals(result.getMember_pw())) {
//					login = true;
//				}
//				else {
//					login = false;
//				}
			}
			else {//아이디 없음
				login = false;
			}
			
//			- 신규 메소드를 만드는 방법
			
//			3. 성공/실패에 따른 리다이렉트 처리
			if(login) {
				resp.sendRedirect("../index.jsp");//상대경로
//				resp.sendRedirect(req.getContextPath()+"/index.jsp");//절대경로
			}
			else {
				resp.sendRedirect("login.jsp?error");//상대경로
//				resp.sendRedirect(req.getContextPath()+"/member/login.jsp");//절대경로
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
