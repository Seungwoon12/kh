package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//주의 : 주소를 작성할 때 반드시 /로 시작해야 한다.
@WebServlet(urlPatterns = "/quiz1.do")
public class Quiz1Servlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		주소에서 age라는 변수를 받아서 요금을 계산하고 화면에 출력
//		준비 : req에서 파라미터를 확인(자바에서는 Scanner로 처리했었음)
//		계산 : 
//		출력 : resp에서 writer를 이용하여 처리(자바에서는 System.out.println()으로 처리했었음)
		
//		String age = req.getParameter("age");
//		int age2 = Integer.parseInt(age);
		int age = Integer.parseInt(req.getParameter("age"));
		
//		int fare = 1250 or 720 or 450 or 0;
		int fare;
		if(age >= 65 || age < 8) {
			fare = 0;
		}
		else if(age >= 20) {
			fare = 1250;
		}
		else if(age >= 14) {
			fare = 720;
		}
		else {
			fare = 450;
		}
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(fare);
	}
}