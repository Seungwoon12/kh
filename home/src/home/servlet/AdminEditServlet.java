package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns = "/admin/edit.do")
public class AdminEditServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 5개의 데이터(MemberDto) 수신
			req.setCharacterEncoding("UTF-8");
			MemberDto dto = new MemberDto();
			dto.setMember_no(Integer.parseInt(req.getParameter("member_no")));
			dto.setMember_nick(req.getParameter("member_nick"));
			dto.setMember_birth(req.getParameter("member_birth"));
			dto.setMember_auth(req.getParameter("member_auth"));
			dto.setMember_point(Integer.parseInt(req.getParameter("member_point")));
			
//			처리 : 데이터 수정 지시(회원에서의 수정과는 다름)
			MemberDao dao = new MemberDao();
//			boolean result = dao.edit(dto);//일반회원용 수정
			boolean result = dao.editByAdmin(dto);
			
//			출력 : 해당 회원의 상세 페이지로 이동
			if(result) {
				resp.sendRedirect("detail.jsp?member_no="+dto.getMember_no());
//				resp.sendRedirect("detail.jsp?member_no=<%=dto.getMember_no()%>");//주의 : 표현식은 JSP에서만 가능
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