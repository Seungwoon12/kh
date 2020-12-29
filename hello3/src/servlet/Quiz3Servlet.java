package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/quiz3.do")
public class Quiz3Servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		String a = type.substring(0, 2);
		String b = type.substring(3);
		int changeRate = 1000;
		int result = 0;
		
		if(a.equals("kr") && b.equals("us")) {
			result = amount / changeRate;
		}
		else if(a.equals("us") && b.equals("kr")) {
			result = amount * changeRate;
		}
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		resp.getWriter().println(result);
		
		
		
	}
}
