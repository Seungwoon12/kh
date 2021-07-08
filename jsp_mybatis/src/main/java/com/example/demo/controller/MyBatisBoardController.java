package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.MyBatisBoard;
import com.example.demo.service.MyBatisBoardService;

@Controller
@RequestMapping("/board")
public class MyBatisBoardController {
	
	private final static Logger log =
			LoggerFactory.getLogger(MyBatisBoardController.class);
	
	@Autowired
	private MyBatisBoardService service;
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		log.info("list()");
		
		model.addAttribute("list", service.list());
	}
	
	@GetMapping("/register")
	public void registerForm(MyBatisBoard myBatisBoard, Model model) throws Exception {
		// 헝가리언 표기법에서는 무조건 이니셜 단위의 대문자 표기가 필요함
		// 근대 Java Beans를 만들고 설계한 누군가가 ?!
		// 반드시 저렇게 헝가리언 형식의 변수명 및 매서드명 작성 형태로 Bean을 만들도록 설계함
		// 그래서 무조건 저 규칙을 따라야만 연결이 가능하다.
		log.info("registerForm()");
	}
	
	@PostMapping("/register")
	public String register(MyBatisBoard board, Model model) throws Exception {
		log.info("register()");
		
		service.register(board);
		
		model.addAttribute("msg", "등록이 성공적으로 완료되었습니다.");
		
		return "board/success";
	}
	
	@GetMapping("/read")
	public void read(int board_no, Model model) throws Exception {
		log.info("read()");
		
		model.addAttribute(service.read(board_no));
	}
	
	@GetMapping("/modify")
	public void getModify(int board_no, Model model) throws Exception {
		log.info("getModify()");
		
		model.addAttribute(service.read(board_no));
	}
	
	@PostMapping("/modify")
	public String postModify(MyBatisBoard board, Model model) throws Exception {
		log.info("postModify()");
		
		service.modify(board);
		
		model.addAttribute("msg", "수정이 성공적으로 완료되었습니다.");
		
		return "board/success";
	}
	
	@PostMapping("/remove")
	public String remove(int board_no, Model model) throws Exception {
		log.info("remove()");
		
		service.remove(board_no);
		
		model.addAttribute("msg", "삭제가 성공적으로 완료되었습니다.");
		
		return "board/success";
	}
}