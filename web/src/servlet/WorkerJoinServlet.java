package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.WorkerDao;
import beans.WorkerDto;

@WebServlet(urlPatterns = "/worker/join.do")
public class WorkerJoinServlet extends HttpServlet{
	//등록은 form을 이용하여 데이터 전송되어 오므로 POST로 받는 것이 바람직하다
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//준비 : 이름, 고용일, 급여액, 직급
			req.setCharacterEncoding("UTF-8");
			String worker_name = req.getParameter("worker_name");
			String hire_date = req.getParameter("hire_date");
			int salary = Integer.parseInt(req.getParameter("salary"));
			String position = req.getParameter("position");
			
			//처리
			WorkerDto dto = new WorkerDto();
			dto.setWorker_name(worker_name);
			dto.setHire_date(hire_date);
			dto.setSalary(salary);
			dto.setPosition(position);
			
			WorkerDao dao = new WorkerDao();
			dao.insert(dto);
			
			//결과
			//resp.setHeader("Content-Type", "text/plain; charset=UTF-8");
			//resp.setContentType("text/plain; charset=UTF-8");
			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().println("등록 완료!");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}