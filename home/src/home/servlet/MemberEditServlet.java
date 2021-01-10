package home.servlet;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

/**
 *	회원 정보 중에서 닉네임과 생년월일을 변경하는 서블릿
 *	변경을 아무나 하지 못하도록 비밀번호 확인 과정을 거친다
 *	비밀번호가 맞지 않으면 입력 페이지로 되돌리고, 맞으면 정보를 수정한다.
 *	회원번호는 세션에 있는 것을 사용한다(조작 불가, 보안 향상). 
 */
@WebServlet(urlPatterns = "/member/edit.do")
public class MemberEditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			준비 : 세션에서 회원번호 획득, 파라미터에서 닉네임, 생년월일, 비밀번호를 획득 ===> 회원정보(MemberDto)
			req.setCharacterEncoding("UTF-8");
			MemberDto dto = new MemberDto();
			dto.setMember_no((int)req.getSession().getAttribute("check"));
			dto.setMember_nick(req.getParameter("member_nick"));
			dto.setMember_birth(req.getParameter("member_birth"));
			dto.setMember_pw(req.getParameter("member_pw"));
			
//			처리 : 번호와 비밀번호로 검사한 다음 닉네임과 생년월일을 수정
			MemberDao dao = new MemberDao();
			boolean result = dao.edit(dto);
			
//			출력 : 성공 시 내정보 페이지로 이동, 실패 시 정보 입력 페이지로 "오류"임을 알리며 전송
			if(result) {
				resp.sendRedirect("my.jsp");
			}
			else {
				resp.sendRedirect("edit.jsp?error");
			}
		}
		catch(SQLIntegrityConstraintViolationException e) {
			resp.sendRedirect("edit.jsp?nick");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
