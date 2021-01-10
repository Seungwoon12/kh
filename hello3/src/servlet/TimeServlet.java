package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/time.kh")
public class TimeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp를 이용하여 할 수 있는 작업들에 대해서 살펴본다.
		// = 응답 정보 객체로서 사용자에게 보여질 정보들을 설정하거나 제어할 수 있다.
		
		//resp를 이용하면 사용자가 받을 화면의 형태를 정할 수 있다.
		// = 텍스트 문서 , HTML 파일 , 음악 파일 , 동영상 파일 , PDF , PPTX
		// = MIME type 이라고 부르며, 대분류/소분류 형태로 작성
		resp.setContentType("text/plain");
		
		//resp를 이용하면 사용자가 받을 화면의 인코딩 방식을 정할 수 있다.
		// = EUC-KR , CP949(MS949) , UTF-8
		resp.setCharacterEncoding("UTF-8");
		
		//resp에 내장된 출력도구를 이용하여 메시지를 화면에 출력해라!(sysout 대신)
		resp.getWriter().println("현재시각 : "+LocalDateTime.now());
	}
}