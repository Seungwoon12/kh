package mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.Controller;
import mvc.controller.ControllerFactory;

//만능 서블릿
//= 주소는 .do로 끝날 것
//= 전송방식은 아무거나 상관없음
@WebServlet(urlPatterns = "*.do")
public class GeniusServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//1. 사용자가 요청한 주소를 분석해야 한다.
			//= 주소 : req.getRequestURI() - req.getContextPath()
			String url = req.getRequestURI().substring(req.getContextPath().length());
			//System.out.println("주소 = " + url);
			
			//2. 주소에 맞는 일꾼선택
			Controller controller = ControllerFactory.create(url);
			
			//3. 일꾼에게 작업을 지시하고 연결할 주소를 받는다
			String nextPage;
			if(controller != null) {
				nextPage = controller.process(req, resp);
			}
			else {
				nextPage = null;
			}
			
			//4. 주소에 따라 페이지 연결
			if(nextPage == null) {
				resp.sendError(404);
			}
			else {
				req.getRequestDispatcher(nextPage).forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}