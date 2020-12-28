package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	서블릿(Servlet)
	- 웹에서 서비스가 가능한 자바파일
	- 처음부터 다 만들것이 아니므로 제공되는 HttpServlet을 상속
	- HttpServlet은 자바 표준 API가 아니라 Apache Tomcat에서 제공
	- 처리방식을 구분하지 않으면 service 메소드를 재정의
	- 처리방식을 구분한다면 해당하는 방식의 메소드를 재정의
	- @WebServlet으로 사용할 서블릿을 등록(옵션으로 주소 설정)
 */

@WebServlet(urlPatterns = "/test.do")
public class TestServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req : 사용자(손님) 주문 정보
		//resp : 사용자가 가져갈 결과물(화면)의 정보
		
		//이곳에 코드를 작성하여 사용자에게 보여질 내용을 만든다(주문제작)
		//= 사용자가 받게될 화면은 resp의 명령을 이용하여 만들어 낼 수 있다.
		
		//resp가 가진 writer를 꺼내어 Hello를 출력하도록 지시한다.
		//System.out.println("Hello");
		resp.getWriter().println("Hello");
	}
	
}