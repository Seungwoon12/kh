package com.khfinal2.cluster.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khfinal2.cluster.service.AdminService;
import com.khfinal2.cluster.service.util.DateUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final static Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/home")
	public String adminHome(Locale locale, Model model) throws Exception {
		
		log.info("adminHome()");
		
		//현재 날짜
		Date date = new Date();
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String serverTime = dateFormat.format(date);
		
		model.addAttribute("serverTime", serverTime);
		
		
		//////////////총 회원수 구하는 코드 시작
		
		//최근 6개월 + 이번달 구해서 monthList에 넣기. DateUtil의 addMonth메소드사용
		Date[] monthList = new Date[7];
		
		for(int i=0, j=-6; i <= 6; j++, i++) {
			if(i == 6) {
				monthList[i] = date;
				break;
			}
			monthList[i] = DateUtil.addMonth(date, j);  
		}
		
		model.addAttribute("monthList", monthList);
		
		//최근 6개월  ~ 이번달까지 해당 시기의 총 회원수 구하기. ex) 2021년3월의 총 회원수, 2021년 4월의 총 회원수 ...
		model.addAttribute("memberCountList", service.getCountMember());
		
		///////////////////윗줄까지 총 회원수 구하는 코드 끝
		
		
		
		////////////////////일별 회원가입 수 구하는 코드 시작
		//오늘 포함 최근 7일에 관한 날짜 정보를 구해서 dayList 배열에 넣기. DateUtil의 addDays메소드사용
		
		Date[] dayList = new Date[7];
		
		for(int i=0, j=-6; i <= 6; j++, i++) {
			if(i == 6) {
				dayList[i] = date;
				break;
			}
			dayList[i] = DateUtil.addDays(date, j);  
		}
		
		model.addAttribute("dayList", dayList);
		
		//오늘 ~ 6일전까지 일별 회원가입 수 데이터 구하기
		model.addAttribute("memberJoinList",service.getCountJoin());
		
		//////////////윗줄까지 일별 회원가입 수 구하는 코드 끝
	
		
		//////////////최근 6개월 + 이번달 월매출액 가져오기
		model.addAttribute("monthSales", service.getMonthSales());
		
		
		/////////////최근 6일 + 오늘 매출액 가져오기
		model.addAttribute("daySales", service.getDaySales());
		
		
		//매출액 Top10 클래스 가져오기
		model.addAttribute("listForTop10Sales", service.getTop10Sales());
		
		//판매수 Top10 클래스 가져오기
		model.addAttribute("listForTop10Class", service.getTop10Class());
		
		return "admin/home";
	}
	
	
	
	@GetMapping("/creator/creatorList")
	public String creatorList() {
		
		log.info("creatorList()");
		
		return "admin/creator/creatorList";
		
	}
	
	@GetMapping("/creator/income")
	public String income() {
		
		log.info("income");
		
		return "admin/creator/income";
	}
	
	@GetMapping("/class/checkClassOpen")
	public String checkClassOpen(Model model) throws Exception {
		
		log.info("checkClassOpen()");
		
		model.addAttribute("list", service.getClassList());
		
		return "admin/class/checkClassOpen";
	}
	
	@GetMapping("/class/checkClassOpenDetail")
	public String checkClassOpenDetail(@RequestParam(value="classNo", required = true) int classNo, Model model) {
		
		log.info("checkClassOpenDetail()");
		
		//파라미터로 classNo 받아서 검수 클래스 상세페이지보여주기
		model.addAttribute("classNo",classNo);
		
		model.addAttribute("list");
		
		return "admin/class/checkClassOpenDetail";
	}
	
	@GetMapping("/class/openClass")
	public String openClass(Model model) throws Exception {
		
		log.info("openClass()");
		
		model.addAttribute("list", service.getOpenClassList());
		
		return "admin/class/openClass";
	}
	
	@GetMapping("/class/comingSoonClass")
	public String comingSoonClass(Model model) throws Exception {
		
		log.info("comingSoonClass()");
		
		model.addAttribute("list", service.getComingSoonClassList());
		
		return "admin/class/comingSoonClass";
	}
	
	
	@GetMapping("/class/closedClass")
	public String closedClass(Model model) throws Exception {
		
		log.info("closedClass()");
		
		model.addAttribute("list", service.getClosedClassList());
		
		return "admin/class/closedClass";
		
	}
	
	@GetMapping("/member/list")
	public String memberList(@RequestParam("p") int pageNo, Model model) throws Exception {
		
		log.info("memberList()");
		
		//페이지당 보여줄 리스트 개수
		int listSize = 15;
		try {
			if(pageNo <= 0) throw new Exception();
		}
		catch(Exception e) {
			pageNo = 1;
		}
		
		int endRow = pageNo * listSize;
		int startRow = endRow - listSize + 1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		
		//페이지 네비게이션 
		int pageNavSize = 5;
		
		int startNum = (pageNo-1) / pageNavSize * pageNavSize + 1;
		int endNum = startNum + pageNavSize - 1;
		
		//회원이 몇명인지
		int count = service.countMemberList();
		
		
		//필요한 페이지 개수
		int pageSize = (count + listSize - 1) / listSize;
		
		if(endNum > pageSize) endNum = pageSize;
		
		
		model.addAttribute("list", service.memberList(map));
		model.addAttribute("startNum", startNum);
		model.addAttribute("endNum", endNum);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNo", pageNo);
		
		return "admin/member/list";
	}
	
	@PostMapping("/member/list")
	public String searchMember(@RequestParam String type, @RequestParam String key, Model model) throws Exception {
		
		log.info("searchMember()");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("key", key);
		
		model.addAttribute("list", service.searchMember(map));
		
		return "admin/member/list";
		
	}
	
	@GetMapping("/sales/total")
	public String total() {
	
		log.info("total()");
		
		return "admin/sales/total";
	}
	
	@GetMapping("/sales/particular")
	public String particular() {
	
		log.info("particular()");
		
		return "admin/sales/particular";
	}
	
	@GetMapping("/event/list")
	public String eventList() {
		
		log.info("eventList()");
		
		return "admin/event/list";
	}
	
	@GetMapping("/category/list")
	public String categoryList() {
		
		log.info("categoryList()");
		
		return "admin/category/list";
	}
	
	@GetMapping("/category/add")
	public String categoryAdd() {
		
		log.info("categoryAdd()");
		
		return "admin/category/add";
	}
	
}