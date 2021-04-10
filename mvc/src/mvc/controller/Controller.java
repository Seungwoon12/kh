package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러의 원형
public interface Controller {
	String process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}