package com.kh.spring07.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.spring07.entity.MemberDto;
import com.kh.spring07.entity.MemberRankVO;

//MemberDao를 Spring이 생성할 수 있도록 등록한다.
// = @Controller로 등록해야 하나? 요청을 받지 않으므로 @Controller는 아니다.
// = @Controller 말고 등록할 수 있는 것이 무엇이 있는가?
// = 아주 많다(@Component, @Service, @Repository, ...)
// = 뭘로 해도 상관은 없지만 일반적으로 DAO는 @Repository를 사용한다.
@Repository
public class MemberDao {
	
	//계정정보를 상수로 저장
	public static final String USERNAME = "web";
	public static final String PASSWORD = "web";
	
	//등록
	public void insert(MemberDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "insert into member values("
				+ "member_seq.nextval, ?, ?, ?, ?, '일반', 0, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getMember_id());
		ps.setString(2, dto.getMember_pw());
		ps.setString(3, dto.getMember_nick());
		ps.setString(4, dto.getMember_birth());
		ps.execute();
		
		con.close();
	}
	
	//목록
	public List<MemberDto> select() throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from member order by member_id asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<MemberDto> list = new ArrayList<>();
		while(rs.next()) {
			MemberDto dto = new MemberDto();
			dto.setMember_no(rs.getInt("member_no"));
			dto.setMember_id(rs.getString("member_id"));
			dto.setMember_pw(rs.getString("member_pw"));
			dto.setMember_nick(rs.getString("member_nick"));
			dto.setMember_birth(rs.getString("member_birth"));
			dto.setMember_auth(rs.getString("member_auth"));
			dto.setMember_point(rs.getInt("member_point"));
			dto.setMember_join(rs.getDate("member_join"));
			
			list.add(dto);
		}
		
		con.close();
		
		return list;
	}

	//검색 : keyword를 이용한 아이디 "시작검사"
	public List<MemberDto> select(String keyword) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
//		String sql = "select * from member where member_id like ?||'%' order by member_id asc";
		String sql = "select * from member where instr(member_id, ?) = 1 order by member_id asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		List<MemberDto> list = new ArrayList<>();
		while(rs.next()) {
			MemberDto dto = new MemberDto();
			dto.setMember_no(rs.getInt("member_no"));
			dto.setMember_id(rs.getString("member_id"));
			dto.setMember_pw(rs.getString("member_pw"));
			dto.setMember_nick(rs.getString("member_nick"));
			dto.setMember_birth(rs.getString("member_birth"));
			dto.setMember_auth(rs.getString("member_auth"));
			dto.setMember_point(rs.getInt("member_point"));
			dto.setMember_join(rs.getDate("member_join"));
			
			list.add(dto);
		}
		
		con.close();
		
		return list;
	}
	
	public List<MemberDto> select(String type, String keyword) throws Exception {
//		분류나 검색어 중 하나라도 없으면 null 반환
		if(type == null || keyword == null) return null;
		
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from member where instr(#1, ?) > 0 order by member_id asc";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		List<MemberDto> list = new ArrayList<>();
		while(rs.next()) {
			MemberDto dto = new MemberDto();
			dto.setMember_no(rs.getInt("member_no"));
			dto.setMember_id(rs.getString("member_id"));
			dto.setMember_pw(rs.getString("member_pw"));
			dto.setMember_nick(rs.getString("member_nick"));
			dto.setMember_birth(rs.getString("member_birth"));
			dto.setMember_auth(rs.getString("member_auth"));
			dto.setMember_point(rs.getInt("member_point"));
			dto.setMember_join(rs.getDate("member_join"));
			
			list.add(dto);
		}
		
		con.close();
		
		return list;
	}
	
	//상세보기(단일조회)
	public MemberDto find(int member_no) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from member where member_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, member_no);
		ResultSet rs = ps.executeQuery();
		
		MemberDto dto;
		if(rs.next()) {
			dto = new MemberDto();
			dto.setMember_no(rs.getInt("member_no"));
			dto.setMember_id(rs.getString("member_id"));
			dto.setMember_pw(rs.getString("member_pw"));
			dto.setMember_nick(rs.getString("member_nick"));
			dto.setMember_birth(rs.getString("member_birth"));
			dto.setMember_point(rs.getInt("member_point"));
			dto.setMember_auth(rs.getString("member_auth"));
			dto.setMember_join(rs.getDate("member_join"));
		}
		else {
			dto = null;
		}
		
		con.close();
		
		return dto;
	}

	public MemberDto find(String member_id) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from member where member_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member_id);
		ResultSet rs = ps.executeQuery();
		
		MemberDto dto;
		if(rs.next()) {
			dto = new MemberDto();
			dto.setMember_no(rs.getInt("member_no"));
			dto.setMember_id(rs.getString("member_id"));
			dto.setMember_pw(rs.getString("member_pw"));
			dto.setMember_nick(rs.getString("member_nick"));
			dto.setMember_birth(rs.getString("member_birth"));
			dto.setMember_point(rs.getInt("member_point"));
			dto.setMember_auth(rs.getString("member_auth"));
			dto.setMember_join(rs.getDate("member_join"));
		}
		else {
			dto = null;
		}
		
		con.close();
		
		return dto;		
	}
	
	//로그인
	public boolean login(MemberDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from member where member_id=? and member_pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getMember_id());
		ps.setString(2, dto.getMember_pw());
		ResultSet rs = ps.executeQuery();//데이터는 많아야 1개
		
		boolean result = rs.next();//있어요?
//		boolean result;
//		if(rs.next()) {
//			result = true;
//		}
//		else {
//			result = false;
//		}
		
		con.close();
		
		return result;
	}
	
//	회원탈퇴 기능 : 회원탈퇴 페이지와 관리자 페이지에서 이용할 기능
	public boolean delete(int member_no) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "delete member where member_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, member_no);
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
	
//	회원정보 수정
	public boolean edit(MemberDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "update member "
						+ "set member_nick=?, member_birth=? "
						+ "where member_no=? and member_pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getMember_nick());
		ps.setString(2, dto.getMember_birth());
		ps.setInt(3, dto.getMember_no());
		ps.setString(4, dto.getMember_pw());
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
	
//	비밀번호 변경
	public boolean editPassword(int member_no, String member_pw, String change_pw) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "update member set member_pw=? where member_no=? and member_pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, change_pw);
		ps.setInt(2, member_no);
		ps.setString(3, member_pw);
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0; 
	}
	
//	관리자용 회원수정
	public boolean editByAdmin(MemberDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "update member "
						+ "set member_nick=?, member_birth=?, member_auth=?, member_point=? "
						+ "where member_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getMember_nick());
		ps.setString(2, dto.getMember_birth());
		ps.setString(3, dto.getMember_auth());
		ps.setInt(4, dto.getMember_point());
		ps.setInt(5, dto.getMember_no());
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
	
//	관리자용 임시 비밀번호 생성
	public boolean editPasswordByAdmin(int member_no, String member_pw) throws Exception{
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "update member set member_pw=? where member_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member_pw);
		ps.setInt(2, member_no);
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
	
//	랭킹 리스트 
	public List<MemberRankVO> getPointRank(int start, int end) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from ("
						+ "select "
							+ "M.member_no, M.member_point, M.member_id,"
							+ "M.member_nick, M.member_auth, M.member_join,"
							+ "rank() over(order by member_point desc) rank "
							+ "from member M"
					+ ") where rank between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs = ps.executeQuery();
		
		List<MemberRankVO> list = new ArrayList<>();
		while(rs.next()) {
			MemberRankVO vo = new MemberRankVO();
			vo.setMember_no(rs.getInt("member_no"));
			vo.setMember_id(rs.getString("member_id"));
			vo.setMember_nick(rs.getString("member_nick"));
			vo.setMember_auth(rs.getString("member_auth"));
			vo.setMember_join(rs.getDate("member_join"));
			vo.setMember_point(rs.getInt("member_point"));
			vo.setRank(rs.getInt("rank"));
			
			list.add(vo);
		}
		
		con.close();
		return list;
	}
}