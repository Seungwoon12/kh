package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/param.do")
public class ParamServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req를 이용해서 할 수 있는 작업들에 대해 살펴본다.
		//= 요청 정보 객체로서 사용자가 요구한 내용들과 사용자 정보를 확인할 수 있다.
		
		//req를 이용하면 사용자가 전송한 방식을 알아낼 수 있다.
		//= GET , POST , ...
		//= GET은 주소만으로 요청을 보내는 것(일반적인 가벼운 요청)
		//= POST는 주소와 데이터를 따로 보내는 것(데이터가 포함된 무거운 요청)
		String method = req.getMethod();
		System.out.println("method = "+method);
		
		//req를 이용하여 사용자의 주소(IP)를 알아낼 수 있다.
		//= 사용자를 구분하는 작업을 수행할 수 있다.
		//= 설정을 따로 하지 않으면 IPv6방식으로 가져온다.
		String address = req.getRemoteAddr();
		System.out.println("address = " + address);
		
		//중요!
		//주소에 포함되거나 따로 첨부되어 오는 데이터를 수신할 수 있다.
		//ex : query라는 이름으로 첨부되는 데이터를 확인해본다
		//(주의) 대소문자를 구분하며 무조건 String으로 수신한다. 없으면 null 이다.
		String query = req.getParameter("query");
		System.out.println("query = " + query);
		
		String test = req.getParameter("test");
		System.out.println("test = " + test); 
	}
}
