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

@WebFilter(urlPatterns = {
	"/member/my.jsp",//내정보
	"/member/logout.do",//로그아웃
	"/member/edit.jsp","/member/edit.do",//정보수정
	"/member/delete.do",//회원탈퇴
	"/member/pw.jsp","/member/pw.do",//비밀번호 변경
	"/board/*"//게시판
})
public class MemberFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//목표 : 회원인지 아닌지 판정하는 것(세션에 들어있는 check 데이터 유무)
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
//		Integer member_no = (Integer)req.getSession().getAttribute("check");
//		boolean isLogin = member_no != null;
		boolean isLogin = req.getSession().getAttribute("check") != null;
		
		if(isLogin) {
			chain.doFilter(request, response);
		}
		else {
//			resp.sendError(401);//401(Unauthorize, 미인증)
			
//			필터도 어느 페이지에서 실행될지 모르기 때문에 절대경로 사용
//			resp.sendRedirect("http://localhost:8888/home/member/login.jsp");
//			resp.sendRedirect("/home/member/login.jsp");
			resp.sendRedirect(req.getContextPath()+"/member/login.jsp");
		}
	}
}