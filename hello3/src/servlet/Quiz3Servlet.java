package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/quiz3.do")
public class Quiz3Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		준비 : type , amount
		String type = req.getParameter("type");
		int amount = Integer.parseInt(req.getParameter("amount"));
		
//		계산
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
//		if(한국 원화를 달러로 바꾸는 상황이라면) {
		if(type.equals("kr-us")) {
			double usd = amount * 0.00091;
			resp.getWriter().println(amount+"원을 달러로 바꾸면 다음과 같습니다");
			resp.getWriter().println(usd+"달러");
		}
		else if(type.equals("us-kr")) {
			double krw = amount * 1093.89;
			resp.getWriter().println(amount+"달러를 원으로 바꾸면 다음과 같습니다");
			resp.getWriter().println(krw+"원");
		}
		
	}
}
