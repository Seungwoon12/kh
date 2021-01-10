package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	
	//등록
	
	public void insert(MemberDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		String sql = "insert into member"
				+ "(member_no, member_id, member_pw, member_nick, member_birth, member_auth) values"
				+ "(member_seq.nextval, ?, ?, ?, ?, '일반')";
		
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
		Connection con = JdbcUtil.getConnection("web", "web");
		
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
		Connection con = JdbcUtil.getConnection("web", "web");
		
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
		Connection con = JdbcUtil.getConnection("web", "web");
		
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
		Connection con = JdbcUtil.getConnection("web", "web");
		
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
	
	public boolean delete(int member_no) throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		String sql = "delete member where member_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, member_no);
		
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
		
		}
}
