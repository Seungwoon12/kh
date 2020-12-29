package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/param.do")
public class ParamServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		System.out.println("method = " + method);
		
		String address = req.getRemoteAddr();
		System.out.println("address = "+address);
		
		String query = req.getParameter("query");
		System.out.println("query = "+query);
		
		String test = req.getParameter("test");
		System.out.println("test = "+test);
				
	}
}
