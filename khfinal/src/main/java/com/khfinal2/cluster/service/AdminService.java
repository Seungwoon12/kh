package com.khfinal2.cluster.service;

import java.util.List;
import java.util.Map;

import com.khfinal2.cluster.entity.AdminOffclassVO;
import com.khfinal2.cluster.entity.AdminTopClassVO;
import com.khfinal2.cluster.entity.AdminTopSalesVO;
import com.khfinal2.cluster.entity.Member;

public interface AdminService {
	
	//페이징에 따른 회원목록 조회
	public List<Member> memberList(Map<String, Integer> map) throws Exception;

	//검색을 통한 회원목록 조회	
	public List<Member> searchMember(Map<String, String> map) throws Exception;
	
	//회원이 몇명인지 조회
	public Integer countMemberList() throws Exception;
	
	//관리자 메인페이지 총매출액 TOP10 클래스 조회
	public List<AdminTopSalesVO> getTop10Sales() throws Exception;
	
	//관리자 메인페이지 총판매수 Top10 클래스 조회
	public List<AdminTopClassVO> getTop10Class() throws Exception;
	
	//이번달 + 최근 6개월간 기간별 회원수
	public List<Integer> getCountMember() throws Exception;
	
	//오늘 ~ 6일전 회원가입 수
	public List<Integer> getCountJoin() throws Exception;
	
	//최근 6개월 + 이번달 월 매출액
	public List<Long> getMonthSales() throws Exception;
	
	//최근 6일 + 오늘 매출액
	public List<Long> getDaySales() throws Exception;
	
	// 클래스 검수 페이지에 출력할 클레스 리스트
	public List<AdminOffclassVO> getClassList() throws Exception;
	
	//진행중인 클래스 가져오기
	public List<AdminOffclassVO> getOpenClassList() throws Exception;
	
	//오픈 예정 클래스 가져오기
	public List<AdminOffclassVO> getComingSoonClassList() throws Exception;
	
	//종료된 클래스 가져오기
	public List<AdminOffclassVO> getClosedClassList() throws Exception;
	
	

}
