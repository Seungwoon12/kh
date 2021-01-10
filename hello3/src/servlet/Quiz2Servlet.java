package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/quiz2.do")
public class Quiz2Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//입력 : people, day, month
		int people = Integer.parseInt(req.getParameter("people"));
		int day = Integer.parseInt(req.getParameter("day"));
		int month = Integer.parseInt(req.getParameter("month"));
		
		//계산
		//int rate = 30 or 0 or 15 or 5;
		int rate;
		if(month / 3 == 1)		rate = 30;
		else if(month / 3 == 2)	rate = 0;
		else if(month / 3 == 3)	rate = 15;
		else 					rate = 5;
		
		int total = people * day * 100000;
		int discount = total * rate / 100;
		int result = total - discount;
		
		//출력
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(result);
	}
}
