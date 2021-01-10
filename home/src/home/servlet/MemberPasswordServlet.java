package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

/**
 * 비밀번호를 변경하는 서블릿
 * 사용자가 입력한 현재 비밀번호와 변경할 비밀번호, 세션의 회원번호를 이용하여 "비밀번호 검사 후 변경" 작업을 수행
 */
@WebServlet(urlPatterns = "/member/pw.do")
public class MemberPasswordServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 세션(회원번호) , 파라미터(현재비밀번호, 바꿀비밀번호)
			int member_no = (int)req.getSession().getAttribute("check");
			String member_pw = req.getParameter("member_pw");
			String change_pw = req.getParameter("change_pw");
			
//			처리 : 비밀번호 검사 후 변경
			MemberDao dao = new MemberDao();
			boolean result = dao.editPassword(member_no, member_pw, change_pw);
			
//			출력 : 성공하면 마이페이지, 실패하면 "오류"정보를 달고 이전 페이지로 가도록 구현
			if(result) {
				resp.sendRedirect("my.jsp");
			}
			else {
				resp.sendRedirect("pw.jsp?error");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}