package com.kh.spring13.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring13.entity.MemberDto;
import com.kh.spring13.entity.MemberRankVO;

//myBatis로 구동되는 Dao 파일
@Repository
public class MemberDaoImpl3 implements MemberDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(MemberDto dto) throws Exception {
		sqlSession.insert("member.join", dto);
	}

	@Override
	public boolean login(MemberDto dto) throws Exception {
		return sqlSession.selectOne("member.login", dto) != null;
	}

	@Override
	public List<MemberDto> select() throws Exception {
		return sqlSession.selectList("member.list");
	}

	@Override
	public List<MemberDto> select(String keyword) throws Exception {
		return sqlSession.selectList("member.search1", keyword);
	}

	@Override
	public List<MemberDto> select(String type, String keyword) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		param.put("keyword", keyword);
		return sqlSession.selectList("member.search2", param);
	}

	@Override
	public MemberDto find(int member_no) throws Exception {
		return sqlSession.selectOne("member.find", member_no);
	}

	@Override
	public MemberDto find(String member_id) throws Exception {
		return sqlSession.selectOne("member.find2", member_id);
	}

	@Override
	public boolean delete(int member_no) throws Exception {
		return sqlSession.delete("member.drop", member_no) > 0;
	}

	@Override
	public boolean edit(MemberDto dto) throws Exception {
		return sqlSession.update("member.edit", dto) > 0;
	}

	@Override
	public boolean editPassword(int member_no, String member_pw, String change_pw) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("member_no", member_no);
		param.put("member_pw", member_pw);
		param.put("change_pw", change_pw);
		return sqlSession.update("member.editPassword", param) > 0;
	}

	@Override
	public boolean editByAdmin(MemberDto dto) throws Exception {
		return sqlSession.update("member.editByAdmin", dto) > 0;
	}

	@Override
	public boolean editPasswordByAdmin(int member_no, String member_pw) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("member_no", member_no);
		param.put("member_pw", member_pw);
		return sqlSession.update("member.editPasswordByAdmin", param) > 0;
	}

	@Override
	public List<MemberRankVO> getPointRank(int start, int end) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("start", start);
		param.put("end", end);
		return sqlSession.selectList("member.getPointRank", param);
	}
	
}