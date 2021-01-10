package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.PersonDao;
import beans.PersonDto;

@WebServlet(urlPatterns = "/person/regist.do")
public class PersonRegistServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : 어짜피 등록하려면 DTO로 만들어야 하니 미리 받을 때부터 DTO에 저장
			req.setCharacterEncoding("UTF-8");
			PersonDto dto = new PersonDto();
			dto.setPerson_name(req.getParameter("person_name"));
			dto.setJavascore(Integer.parseInt(req.getParameter("javascore")));
			dto.setDbscore(Integer.parseInt(req.getParameter("dbscore")));
			dto.setGender(req.getParameter("gender"));
			
			//처리 : DAO
			PersonDao dao = new PersonDao();
			dao.insert(dto);
			
			//출력
			// - 결과를 보여줄 때 일반 글자(text/plain)가 아니라 HTML형식(text/html)로 보여줘야 한다
			// - 하지만 html 문법을 문자열로 출력하는 행동은 하고 싶지 않다(가독성 저하/작성효율 낮음/오류검사 불가)
			// - 해결책은 외부에 HTML 파일을 만들어놓고 해당 파일로 재접속을 지시(이동)
			// - resp.sendRedirect("다시 접속할 페이지 주소");
			// - resp.sendRedirect("http://localhost:8888/web/person/regist_result.html");
			// - resp.sendRedirect("/web/person/regist_result.html");//절대경로
			resp.sendRedirect("regist_result.html");//상대경로
		}
		catch(Exception e)  { 
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}