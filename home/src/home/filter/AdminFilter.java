package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	필터(Filter)
 *	= 서블릿처럼 주소 설정이 가능한 도구
 *	= 요청을 검사할 수 있는 자격이 있는 도구(서블릿/JSP 실행 전에 실행)
 *	= 생성 과정이 서블릿과 동일한 순서(1.상속 , 2.등록 , 3.메소드 재정의 및 구현)
 *	= 기존에 있는 페이지에 적용시키는 도구 
 *
 *	ServletRequest : 상위(범용) 요청 객체. 실제로는 HttpServletRequest 형태가 들어 있다.
 *	ServletResponse : 상위(범용) 응답 객체. 실제로는 HttpServletResponse 형태가 들어 있다.
 *
 *	Url Pattern 작성 규칙
 *	1.페이지를 직접 작성(ex : /admin/home.jsp)
 *	2.특정 경로를 전부 다 설정하는 방법(ex : /admin/*)
 *	3.특정 확장자를 전부 다 설정하는 방법(ex : *.jsp)
 *	- 주의 : 2번과 3번은 동시에 할 수 없다(ex : /admin/*.jsp)
 */
//@WebFilter(urlPatterns = {
//		"/admin/home.jsp",
//		"/admin/list.jsp",
//		"/admin/detail.jsp",
//		"/admin/edit.jsp",
//		"/admin/edit.do",
//		"/admin/delete.do",
//		"/admin/pw.do",
//		"/admin/pw.jsp"
//})
@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//필터에서는 HTTP요청을 처리하고 싶으면 request, response를 각각 다운캐스팅해서 사용해야 한다.
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//관리자 검사
		String auth = (String)req.getSession().getAttribute("auth");
		boolean isAdmin = auth != null && auth.equals("관리자");
		
		//보내주는 방법(통과 명령)
		if(isAdmin) {
			chain.doFilter(request, response);
		}
		//관리자가 아닌 사람들에 대한 처리
		//= 다른 페이지로 재접속 요청 : resp.sendRedirect("페이지주소");
		//= 에러 메세지 전송 : resp.sendError(상태번호);
		else {
			resp.sendError(403);
		}
	}
}