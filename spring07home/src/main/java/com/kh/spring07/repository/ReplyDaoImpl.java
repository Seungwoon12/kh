package com.kh.spring07.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.spring07.entity.ReplyDto;

@Repository
public class ReplyDaoImpl implements ReplyDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<ReplyDto> mapper = (rs, index)->{
		ReplyDto replyDto = new ReplyDto();
		replyDto.setReply_no(rs.getInt("reply_no"));
		replyDto.setReply_content(rs.getString("reply_content"));
		replyDto.setReply_time(rs.getDate("reply_time"));
		replyDto.setReply_origin(rs.getInt("reply_origin"));
		replyDto.setReply_writer(rs.getString("reply_writer"));
		return replyDto;
	};

	@Override
	public void insert(ReplyDto replyDto) {
		String sql = "insert into reply("
							+ "reply_no, reply_content, reply_time, reply_origin, reply_writer"
						+ ") "
						+ "values(reply_seq.nextval, ?, sysdate, ?, ?)";
		Object[] param = {
				replyDto.getReply_content(),
				replyDto.getReply_origin(),
				replyDto.getReply_writer()
		};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<ReplyDto> select(int reply_origin) {
		String sql = "select * from reply where reply_origin=? order by reply_no asc";
		Object[] param = {reply_origin};
		return jdbcTemplate.query(sql, param, mapper);
	}

	@Override
	public void delete(int reply_no) {
		String sql = "delete reply where reply_no = ?";
		Object[] param = {reply_no};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public void update(ReplyDto replyDto) {
		String sql = "update reply set reply_content = ? where reply_no = ?";
		Object[] param = {replyDto.getReply_content(), replyDto.getReply_no()};
		jdbcTemplate.update(sql, param);
	}
	
	
}