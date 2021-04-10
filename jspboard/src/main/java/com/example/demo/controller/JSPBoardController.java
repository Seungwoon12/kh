package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board")
public class JSPBoardController {
	
	private static final Logger log =
			LoggerFactory.getLogger(JSPBoardController.class);
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) throws Exception {
		log.info("list()");
		
		model.addAttribute("list", service.list());
	}
	
	
	@GetMapping("/register")
	public void registerForm(Board board, Model model) throws Exception {
		log.info("registerForm()");
	}
	
	@PostMapping("/register")
	public String register(Board board, Model model) throws Exception {
		log.info("register()");
		
		service.register(board);
		model.addAttribute("msg", "등록이 성공적으로 완료되었습니다");
		
		return "redirect:/board/success";
	}
	
	@GetMapping("/read")
	public void read(int boardNo, Model model) throws Exception {
		log.info("read()");
		
		model.addAttribute(service.read(boardNo));
		
	}
	
	@GetMapping("/modify")
	public void getModify(int boardNo, Model model) throws Exception {
		log.info("getModify()");
		
		model.addAttribute(service.read(boardNo));
		
	}
	
	@PostMapping("/modify")
	public String postModify(Board board, Model model) throws Exception {
		log.info("postModify()");
		
		service.modify(board);
		
		model.addAttribute("msg", "수정이 성공적으로 완료되었습니다.");
		
		return "board/success";
		
	}
	
	@PostMapping("/remove")
	public String remove(int boardNo, Model model) throws Exception {
		log.info("remove()");
		
		service.remove(boardNo);
		
		model.addAttribute("msg", "삭제가 성공적으로 완료되었습니다");
		
		return "board/success";
		
	}
	
	@GetMapping("/success")
	public void getSuccess(Model model) throws Exception {
		log.info("getSuccess()");
		
		model.addAttribute("msg", "성공");
		
		
	}
	
	
	
	
}