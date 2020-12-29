package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/quiz1.do")
public class Quiz1Servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		String method = req.getMethod();
		int  age = Integer.parseInt(req.getParameter("age"));
		int adult = 1250, teenager = 720, child = 450, etc = 0;
		
		
		if(age >= 20 && age <= 64) {
			resp.getWriter().println("성인(20~64) : "+adult+"원");
		}
		else if(age >= 14 && age <= 19) {
			resp.getWriter().println("청소년(14~19) : "+teenager+"원");
		}
		else if(age >= 8 && age <= 13) {
			resp.getWriter().println("어린이(8~13) : "+child+"원");
		}
		else {
			resp.getWriter().println("기타(어르신/유아) : "+etc+"원");
		}
		
		
	}
}
