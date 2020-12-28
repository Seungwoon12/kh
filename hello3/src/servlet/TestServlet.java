package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dice.do")
public class TestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req : 사용자 요청 정보 객체
		//resp : 사용자 응답 정보 객체
		
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		
		resp.getWriter().println(dice);
	}
}