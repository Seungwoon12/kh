package com.khfinal2.cluster.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.khfinal2.cluster.entity.AdminOffclassVO;
import com.khfinal2.cluster.entity.AdminTopClassVO;
import com.khfinal2.cluster.entity.AdminTopSalesVO;
import com.khfinal2.cluster.entity.Member;

@Repository
public interface AdminRepository {

	public List<Member> memberList(Map<String, Integer> map) throws Exception;

	public List<Member> searchMember(Map<String, String> map) throws Exception;
	
	public Integer countMemberList() throws Exception;

	public List<AdminTopSalesVO> getTop10Sales() throws Exception;
	public List<AdminTopClassVO> getTop10Class() throws Exception;


	public Integer get6MonthAgoNumberOfMember() throws Exception;
	public Integer get5MonthAgoNumberOfMember() throws Exception;
	public Integer get4MonthAgoNumberOfMember() throws Exception;
	public Integer get3MonthAgoNumberOfMember() throws Exception;
	public Integer get2MonthAgoNumberOfMember() throws Exception;
	public Integer get1MonthAgoNumberOfMember() throws Exception;
	public Integer getThisMonthNumberOfMember() throws Exception;
	
	public Integer countJoinToday() throws Exception;
	public Integer countJoinTodayMinus1() throws Exception;
	public Integer countJoinTodayMinus2() throws Exception;
	public Integer countJoinTodayMinus3() throws Exception;
	public Integer countJoinTodayMinus4() throws Exception;
	public Integer countJoinTodayMinus5() throws Exception;
	public Integer countJoinTodayMinus6() throws Exception;
	
	public Long get6MonthAgoSales() throws Exception;
	public Long get5MonthAgoSales() throws Exception;
	public Long get4MonthAgoSales() throws Exception;
	public Long get3MonthAgoSales() throws Exception;
	public Long get2MonthAgoSales() throws Exception;
	public Long get1MonthAgoSales() throws Exception;
	public Long getThisMonthSales() throws Exception;
	
	public Long getTodayMinus6Sales() throws Exception;
	public Long getTodayMinus5Sales() throws Exception;
	public Long getTodayMinus4Sales() throws Exception;
	public Long getTodayMinus3Sales() throws Exception;
	public Long getTodayMinus2Sales() throws Exception;
	public Long getTodayMinus1Sales() throws Exception;
	public Long getTodaySales() throws Exception;
	
	public List<AdminOffclassVO> getClassList() throws Exception;
	
	public List<AdminOffclassVO> getOpenClassList() throws Exception;
	
	public List<AdminOffclassVO> getComingSoonClassList() throws Exception;
	
	public List<AdminOffclassVO> getClosedClassList() throws Exception;
	
}
