package mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/plus.do")
public class PlusServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 수신
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		int total = a + b;
		
		//첨부
		//req.setAttribute("a", a);
		//req.setAttribute("b", b);
		req.setAttribute("total", total);
		
		//포워드 코드
		req.getRequestDispatcher("/WEB-INF/views/plus.jsp").forward(req, resp);
	}
}