package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/quiz2.do")
public class Quiz2Servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int people = Integer.parseInt(req.getParameter("people"));
		int day = Integer.parseInt(req.getParameter("day"));
		int month = Integer.parseInt(req.getParameter("month"));
		
		int rate;
		
		switch(month/3) {
		case 1 : 
			rate= 30;
			break;
		case 2 :
			rate = 0;
			break;
		case 3 : 
			rate = 15;
			break;
		default : 
			rate = 5;
			break;
		}
		
		int total = people*day*100000;
		int discount = total*rate/100;
		int result = total - discount;
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		resp.getWriter().println("할인 전 : "+total);
		resp.getWriter().println("할인금액 : "+discount);
		resp.getWriter().println("할인 후  : "+result);
		
	}
}
