package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Board;

@Repository
public class BoardRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void create(Board board) throws Exception {
		String query = "insert into jspboard (board_no, title, content, writer) " +
						"values (jspboard_seq.nextval, ?, ?, ?)";
		
		jdbcTemplate.update(query, board.getTitle(), 
				board.getContent(), board.getWriter());
	}

	public List<Board> list() throws Exception {
		// TODO Auto-generated method stub
		List<Board> results = jdbcTemplate.query(
			"select board_no, title, content, writer, reg_date from jspboard "
			+ "where board_no > 0 order by board_no desc",
			
			new RowMapper<Board>() {

				@Override
				public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Board board = new Board();
					
					board.setBoardNo(rs.getInt("board_no"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setWriter(rs.getString("writer"));
					
					Timestamp timestamp = rs.getTimestamp("reg_date");
					board.setRegDate(timestamp.toLocalDateTime());
					
					return board;
				}
			}
		);
		
		return results;
	}

	public Board read(Integer boardNo) throws Exception {
		List<Board> results = jdbcTemplate.query(
				"select board_no, title, content, writer, reg_date "
				+ "from jspboard where board_no = ?",
				
				new RowMapper<Board>() {

					@Override
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Board board = new Board();
						
						board.setBoardNo(rs.getInt("board_no"));
						board.setTitle(rs.getString("title"));
						board.setContent(rs.getString("content"));
						board.setWriter(rs.getString("writer"));
						
						Timestamp timestamp = rs.getTimestamp("reg_date");
						board.setRegDate(timestamp.toLocalDateTime());
						
						return board;
					}
				}, boardNo
			);
			
			return results.isEmpty() ? null : results.get(0);
	}

	public void update(Board board) {
		String query = "update jspboard set title = ?, content = ? where board_no = ?";
		
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
	}

	public void delete(Integer boardNo) {
		String query = "delete from jspboard where board_no = ?";
		
		jdbcTemplate.update(query, boardNo);
	}
	
	
}