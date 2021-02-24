package com.kh.spring07.repository;
//Spring JDBC를 이용한 데이터베이스 처리를 수행하는 클래스

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.spring07.entity.MemberDto;
import com.kh.spring07.entity.MemberRankVO;

@Repository
public class MemberDaoImpl2 implements MemberDao{
	
	//이 클래스는 작업을 수행하기 위해 등록된 spring bean 중에서 jdbcTemplate이 필요하다.
	// = JdbcTemplate은 기존의 데이터베이스 작업을 단순화 시켜준다
	// = 명령과 그에 따른 값만 추가하는 형태로 간소화
	// = 연결과 종료코드가 사라진다
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(MemberDto dto) throws Exception {
		String sql = "insert into member values("
				+ "member_seq.nextval, ?, ?, ?, ?, '일반', 0, sysdate)";
		Object[] param = {
				dto.getMember_id(), 
				dto.getMember_pw(), 
				dto.getMember_nick(), 
				dto.getMember_birth()
		};
		jdbcTemplate.update(sql, param);
	}
	
//	목록을 조회하기 위해 필수적으로 알아야 할 변환 과정에 대해서 기술한 객체 생성
//	= ResultSet의 한 줄을 어떻게 MemberDto로 바꿀지에 대해서 기술한다!
//	= RowMapper는 함수형 인터페이스(메소드가 1개인 인터페이스)라서 람다(추론) 표현이 가능하다(spring 4.x 이상)
	
//	private RowMapper<MemberDto> mapper = new RowMapper<MemberDto>() {
//		@Override
//		public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//			MemberDto memberDto = new MemberDto();
//			memberDto.setMember_no(rs.getInt("member_no"));
//			memberDto.setMember_id(rs.getString("member_id"));
//			memberDto.setMember_pw(rs.getString("member_pw"));
//			memberDto.setMember_nick(rs.getString("member_nick"));
//			memberDto.setMember_birth(rs.getString("member_birth"));
//			memberDto.setMember_auth(rs.getString("member_auth"));
//			memberDto.setMember_point(rs.getInt("member_point"));
//			memberDto.setMember_join(rs.getDate("member_join"));
//			return memberDto;
//		}
//	};
	
	private RowMapper<MemberDto> mapper = (rs, rowNum)->{
		MemberDto memberDto = new MemberDto();
		memberDto.setMember_no(rs.getInt("member_no"));
		memberDto.setMember_id(rs.getString("member_id"));
		memberDto.setMember_pw(rs.getString("member_pw"));
		memberDto.setMember_nick(rs.getString("member_nick"));
		memberDto.setMember_birth(rs.getString("member_birth"));
		memberDto.setMember_auth(rs.getString("member_auth"));
		memberDto.setMember_point(rs.getInt("member_point"));
		memberDto.setMember_join(rs.getDate("member_join"));
		return memberDto;
	};
	
//	단일조회를 수행하기 위해 필요한 코드를 객체에 작성
//	= 단일조회의 결과는 DTO가 나와야 하므로 RowMapper와는 약간의 차이가 발생
//	= ResultSetExtractor
//	= 함수형 인터페이스이므로 람다(추론) 표현이 가능
//	private ResultSetExtractor<MemberDto> extractor = new ResultSetExtractor<MemberDto>() {
//		@Override
//		public MemberDto extractData(ResultSet rs) throws SQLException, DataAccessException {
//			MemberDto dto;
//			if(rs.next()) {
//				dto = new MemberDto();
//				dto.setMember_no(rs.getInt("member_no"));
//				dto.setMember_id(rs.getString("member_id"));
//				dto.setMember_pw(rs.getString("member_pw"));
//				dto.setMember_nick(rs.getString("member_nick"));
//				dto.setMember_birth(rs.getString("member_birth"));
//				dto.setMember_point(rs.getInt("member_point"));
//				dto.setMember_auth(rs.getString("member_auth"));
//				dto.setMember_join(rs.getDate("member_join"));
//			}
//			else {
//				dto = null;
//			}
//			return dto;
//		}
//	};
	
	private ResultSetExtractor<MemberDto> extractor = (rs)->{
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
		return dto;
	};

	@Override
	public List<MemberDto> select() throws Exception {
		String sql = "select * from member order by member_id asc";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<MemberDto> select(String keyword) throws Exception {
//		String sql = "select * from member where member_id like ?||'%' order by member_id asc";
		String sql = "select * from member where instr(member_id, ?) = 1 order by member_id asc";
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, param, mapper);
	}

	@Override
	public List<MemberDto> select(String type, String keyword) throws Exception {
		if(type == null || keyword == null) return null;
		String sql = "select * from member where instr(#1, ?) > 0 order by member_id asc";
		sql = sql.replace("#1", type);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, param, mapper);
	}

	@Override
	public MemberDto find(int member_no) throws Exception {
		String sql = "select * from member where member_no = ?";
		Object[] param = {member_no};
		return jdbcTemplate.query(sql, param, extractor);
	}

	@Override
	public MemberDto find(String member_id) throws Exception {
		String sql = "select * from member where member_id = ?";
		Object[] param = {member_id};
		return jdbcTemplate.query(sql, param, extractor);
	}

	@Override
	public boolean login(MemberDto dto) throws Exception {
		String sql = "select * from member where member_id=? and member_pw=?";
		Object[] param = {dto.getMember_id(), dto.getMember_pw()};
		return jdbcTemplate.query(sql, param, extractor) != null;
	}

	@Override
	public boolean delete(int member_no) throws Exception {
		String sql = "delete member where member_no=?";
		Object[] param = {member_no};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean edit(MemberDto dto) throws Exception {
		String sql = "update member "
							+ "set member_nick=?, member_birth=? "
							+ "where member_no=? and member_pw=?";
		Object[] param = {
				dto.getMember_nick(),		dto.getMember_birth(),
				dto.getMember_no(),		dto.getMember_pw()
		};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean editPassword(int member_no, String member_pw, String change_pw) throws Exception {
		String sql = "update member set member_pw=? where member_no=? and member_pw=?";
		Object[] param = {change_pw, member_no, member_pw};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean editByAdmin(MemberDto dto) throws Exception {
		String sql = "update member "
				+ "set member_nick=?, member_birth=?, member_auth=?, member_point=? "
				+ "where member_no=?";
		Object[] param = {
				dto.getMember_nick(), dto.getMember_birth(),
				dto.getMember_auth(), dto.getMember_point(), dto.getMember_no()
		};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean editPasswordByAdmin(int member_no, String member_pw) throws Exception {
		String sql = "update member set member_pw=? where member_no=?";
		Object[] param = {member_pw, member_no};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	private RowMapper<MemberRankVO> mapper2 = (rs, index)->{
		MemberRankVO vo = new MemberRankVO();
		vo.setMember_no(rs.getInt("member_no"));
		vo.setMember_id(rs.getString("member_id"));
		vo.setMember_nick(rs.getString("member_nick"));
		vo.setMember_auth(rs.getString("member_auth"));
		vo.setMember_join(rs.getDate("member_join"));
		vo.setMember_point(rs.getInt("member_point"));
		vo.setRank(rs.getInt("rank"));
		return vo;
	};

	@Override
	public List<MemberRankVO> getPointRank(int start, int end) throws Exception {
		String sql = "select * from ("
				+ "select "
					+ "M.member_no, M.member_point, M.member_id,"
					+ "M.member_nick, M.member_auth, M.member_join,"
					+ "rank() over(order by member_point desc) rank "
					+ "from member M"
			+ ") where rank between ? and ?";
		Object[] param = {start, end};
		return jdbcTemplate.query(sql, param, mapper2);
	}
	
	
	
}