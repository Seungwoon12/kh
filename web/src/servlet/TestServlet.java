package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test.do")
public class TestServlet extends HttpServlet{
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		목표 : 화면(HTML/JSP)에서 전달되는 데이터를 받아서 있는 그대로 출력
//		- 전달될 데이터의 이름을 정해야 한다.
//		(주의) POST방식일 경우 한글을 복원하는 코드가 필요하다(전송자체가 ASCII로 오기 때문)
		req.setCharacterEncoding("UTF-8");
		
		String a = req.getParameter("a");
		String b = req.getParameter("b");
		String c = req.getParameter("c");
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("a = " + a);
		resp.getWriter().println("b = " + b);
		resp.getWriter().println("c = " + c);
	}
}
	