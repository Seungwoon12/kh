package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

@WebServlet(urlPatterns = "/admin/delete.do")
public class AdminDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 
//			- 자신이 탈퇴하는 페이지인 /member/delete.do의 경우는 세션에서 본인의 회원번호를 가져와야 한다
//			- 다른회원을 탈퇴시키는 페이지인 /admin/delete.do의 경우는 파라미터를 통해 탈퇴시킬 회원의 번호를 가져와야 한다
			int member_no = Integer.parseInt(req.getParameter("member_no"));
			
//			처리
			MemberDao dao = new MemberDao();
			boolean result = dao.delete(member_no);
			
//			출력
//			= 404는 원래 "페이지가 없어요"라는 뜻인데 변형시켜서 "회원이 없어요"로 사용할 수도 있다(개발자 마음)
			if(result) {
				resp.sendRedirect("list.jsp");
			}
			else {
				resp.sendError(404);//404는 not found라는 의미(응용)
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
