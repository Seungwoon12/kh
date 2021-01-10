package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.WorkerDao;
import beans.WorkerDto;

@WebServlet(urlPatterns = "/worker/list.do")
public class WorkerListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : 없음
			//처리 : 데이터베이스에서 worker테이블의 목록을 조회
			WorkerDao dao = new WorkerDao();
			List<WorkerDto> list = dao.select();
			
			//출력 : 가져온 목록을 화면에 출력(redirect 금지)
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().println("<h1>데이터 개수 : "+list.size()+"</h1>");
			
			for(WorkerDto dto : list) {
				resp.getWriter().print("<div>");
				resp.getWriter().print(dto.getWorker_no());
				resp.getWriter().print("/");
				resp.getWriter().print(dto.getWorker_name());
				resp.getWriter().print("/");
				resp.getWriter().print(dto.getPosition());
				resp.getWriter().print("</div>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
