package com.khfinal2.cluster.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khfinal2.cluster.entity.AdminOffclassVO;
import com.khfinal2.cluster.entity.AdminTopClassVO;
import com.khfinal2.cluster.entity.AdminTopSalesVO;
import com.khfinal2.cluster.entity.Member;
import com.khfinal2.cluster.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repository;
	
	@Override
	public List<Member> memberList(Map<String, Integer> map) throws Exception {
		return repository.memberList(map);
	}

	@Override
	public List<Member> searchMember(Map<String, String> map) throws Exception {
		
		return repository.searchMember(map);
	}

	@Override
	public Integer countMemberList() throws Exception {
		return repository.countMemberList();
	}

	@Override
	public List<AdminTopSalesVO> getTop10Sales() throws Exception {
		return repository.getTop10Sales();
	}
	
	@Override
	public List<AdminTopClassVO> getTop10Class() throws Exception {
		return repository.getTop10Class();
	}
	
	
	@Override
	public List<Integer> getCountMember() throws Exception {
		List<Integer> list = new ArrayList<>();
		
		list.add(repository.get6MonthAgoNumberOfMember());
		list.add(repository.get5MonthAgoNumberOfMember());
		list.add(repository.get4MonthAgoNumberOfMember());
		list.add(repository.get3MonthAgoNumberOfMember());
		list.add(repository.get2MonthAgoNumberOfMember());
		list.add(repository.get1MonthAgoNumberOfMember());
		list.add(repository.getThisMonthNumberOfMember());
		
		return list;
	}
	

	@Override
	public List<Integer> getCountJoin() throws Exception {
		List<Integer> list = new ArrayList<>();
		
		list.add(repository.countJoinTodayMinus6());
		list.add(repository.countJoinTodayMinus5());
		list.add(repository.countJoinTodayMinus4());
		list.add(repository.countJoinTodayMinus3());
		list.add(repository.countJoinTodayMinus2());
		list.add(repository.countJoinTodayMinus1());
		list.add(repository.countJoinToday());
		
		return list;
	}

	@Override
	public List<Long> getMonthSales() throws Exception {
		List<Long> list = new ArrayList<>();
		
		list.add(repository.get6MonthAgoSales());
		list.add(repository.get5MonthAgoSales());
		list.add(repository.get4MonthAgoSales());
		list.add(repository.get3MonthAgoSales());
		list.add(repository.get2MonthAgoSales());
		list.add(repository.get1MonthAgoSales());
		list.add(repository.getThisMonthSales());
		
		return list;
	}

	@Override
	public List<Long> getDaySales() throws Exception {
		List<Long> list = new ArrayList<>();
		
		list.add(repository.getTodayMinus6Sales());
		list.add(repository.getTodayMinus5Sales());
		list.add(repository.getTodayMinus4Sales());
		list.add(repository.getTodayMinus3Sales());
		list.add(repository.getTodayMinus2Sales());
		list.add(repository.getTodayMinus1Sales());
		list.add(repository.getTodaySales());
		
		return list;
	}

	@Override
	public List<AdminOffclassVO> getClassList() throws Exception {
		
		return repository.getClassList();
	}

	@Override
	public List<AdminOffclassVO> getOpenClassList() throws Exception {
		return repository.getOpenClassList();
	}

	@Override
	public List<AdminOffclassVO> getComingSoonClassList() throws Exception {
		return repository.getComingSoonClassList();
	}

	@Override
	public List<AdminOffclassVO> getClosedClassList() throws Exception {
		return repository.getClosedClassList();
	}

	

	
	
	
	
}
