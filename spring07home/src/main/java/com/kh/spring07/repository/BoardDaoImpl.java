package com.kh.spring07.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.spring07.entity.BoardDto;
import com.kh.spring07.entity.BoardReplyCountVO;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<BoardDto> dtoMapper = (rs, index)->{
		BoardDto dto = new BoardDto();
		dto.setBoard_no(rs.getInt("board_no"));
		dto.setBoard_writer(rs.getString("board_writer"));
		dto.setBoard_header(rs.getString("board_header"));
		dto.setBoard_title(rs.getString("board_title"));
		dto.setBoard_content(rs.getString("board_content"));
		dto.setBoard_read(rs.getInt("board_read"));
		dto.setBoard_time(rs.getDate("board_time"));
		return dto;
	};
	private ResultSetExtractor<BoardDto> extractor = (rs)->{
		BoardDto dto;
		if(rs.next()) {//결과가 있다면 객체를 만들어 데이터베이스 값을 전부다 복사하겠다
			dto = new BoardDto();
			dto.setBoard_no(rs.getInt("board_no"));
			dto.setBoard_writer(rs.getString("board_writer"));
			dto.setBoard_header(rs.getString("board_header"));
			dto.setBoard_title(rs.getString("board_title"));
			dto.setBoard_content(rs.getString("board_content"));
			dto.setBoard_read(rs.getInt("board_read"));
			dto.setBoard_time(rs.getDate("board_time"));
		}
		else {//결과가 없다면 잘못된 번호니까 null이라는 값을 반환하겠다
			dto = null;
		}
		return dto;
	};
	private RowMapper<BoardReplyCountVO> voMapper = (rs, index) ->{
		BoardReplyCountVO vo = new BoardReplyCountVO();
		vo.setBoard_no(rs.getInt("board_no"));
		vo.setBoard_writer(rs.getString("board_writer"));
		vo.setBoard_header(rs.getString("board_header"));
		vo.setBoard_title(rs.getString("board_title"));
		vo.setBoard_content(rs.getString("board_content"));
		vo.setBoard_read(rs.getInt("board_read"));
		vo.setBoard_time(rs.getDate("board_time"));
		vo.setReply_count(rs.getInt("reply_count"));
		return vo;
	};

	@Override
	public void write(BoardDto dto) {
		String sql = "insert into board("
				+ "board_no, board_writer, board_header, board_title, board_content"
			+ ") values(board_seq.nextval, ?, ?, ?, ?)";
		Object[] param = {
				dto.getBoard_writer(),
				dto.getBoard_header(),
				dto.getBoard_title(),
				dto.getBoard_content()
		};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<BoardDto> select() {
		String sql = "select * from board order by board_no desc";
		return jdbcTemplate.query(sql, dtoMapper);
	}

	@Override
	public List<BoardDto> select(String keyword) {
		String sql = "select * from board "
				+ "where instr(board_title, ?) > 0 "
				+ "order by board_no desc";
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, param, dtoMapper);
	}

	@Override
	public List<BoardDto> select(String type, String keyword) {
		String sql = "select * from board where instr(#1, ?) > 0 order by board_no desc";
		sql = sql.replace("#1", type);
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, param, dtoMapper);
	}

	@Override
	public BoardDto find(int board_no) {
		String sql = "select * from board where board_no = ?";//결과가 절대로 여러개가 나올 수 없다
		Object[] param = {board_no};
		return jdbcTemplate.query(sql, param, extractor);
	}

	@Override
	public boolean update(BoardDto dto) {
		String sql = "update board "
				+ "set board_header=?, board_title=?, board_content=? "
				+ "where board_no=?";
		Object[] param = {
				dto.getBoard_header(),
				dto.getBoard_title(),
				dto.getBoard_content(),
				dto.getBoard_no()
		};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public boolean delete(int board_no) {
		String sql = "delete board where board_no=?";
		Object[] param = {board_no};
		return jdbcTemplate.update(sql, param) > 0;
	}

	@Override
	public int getSequence() {
		String sql = "select board_seq.nextval from dual";
		//이 구문은 숫자가 하나 나오게 되는데, dtoMapper나 extractor를 쓸 수 없다.
		//이럴 때에는 queryForObject 명령을 사용한다.(단일항목조회)
		//뒤에 int.class라고 명시해서 나와야 할 객체의 클래스 타입을 지정해준다.(Integer.class도 가능)
		//return jdbcTemplate.queryForInt(sql); //3.x 에서만 사용 가능
		return jdbcTemplate.queryForObject(sql, int.class);//4.x 이후에도 가능한 코드
	}

	@Override
	public void writeWithPrimaryKey(BoardDto boardDto) {
		String sql = "insert into board values(?, ?, ?, ?, ?, 0, sysdate)";
		Object[] param = {
			boardDto.getBoard_no(),
			boardDto.getBoard_writer(),
			boardDto.getBoard_header(),
			boardDto.getBoard_title(),
			boardDto.getBoard_content()
		};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public void plusReadcount(int board_no) {
		String sql = "update board set board_read=board_read+1 where board_no=?";
		Object[] param = {board_no};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<BoardDto> pagingList(String type, String key, int startRow, int endRow) {
		String sql = 	"select * from(" + 
						"select rownum rn, TMP.* from(" + 
							"select * from board "
							+ "where instr(#1, ?) > 0 "
							+ "order by board_no desc" + 
						")TMP" + 
					") where rn between ? and ?";
		sql = sql.replace("#1", type);
		Object[] param = {key, startRow, endRow};
		return jdbcTemplate.query(sql, param, dtoMapper);
	}

	@Override
	public List<BoardDto> pagingList(int startRow, int endRow) {
		String sql = 	"select * from(" + 
						"select rownum rn, TMP.* from(" + 
							"select * from board order by board_no desc" + 
						")TMP" + 
					") where rn between ? and ?";
		Object[] param = {startRow, endRow};
		return jdbcTemplate.query(sql, param, dtoMapper);
	}

	@Override
	public int getCount(String type, String key) {
		String sql = "select count(*) from board where instr(#1, ?) > 0";
		sql = sql.replace("#1", type);
		Object[] param = {key};
		return jdbcTemplate.queryForObject(sql, param, int.class);//값이 한 개만 나올 경우 사용
	}

	@Override
	public int getCount() {
		String sql = "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);//값이 한 개만 나올 경우 사용
	}

	@Override
	public List<BoardReplyCountVO> pagingReplyCountList(int startRow, int endRow) {
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select "
									+ "B.board_no, B.board_header, B.board_writer, B.board_title, B.board_content, "
									+ "B.board_read, B.board_time, "
									+ "count(R.reply_no) reply_count "
								+ "from "
								+ "board B left outer join reply R on B.board_no = R.reply_origin "
								+ "group by "
									+ "B.board_no, B.board_header, B.board_writer, B.board_title, B.board_content, "
									+ "B.board_read, B.board_time "
								+ "order by B.board_no desc "
							+ ")TMP "
						+ ") where rn between ? and ?";
		Object[] param = {startRow, endRow};
		return jdbcTemplate.query(sql, param, voMapper);
	}

	@Override
	public List<BoardReplyCountVO> pagingReplyCountList(String type, String key, int startRow, int endRow) {
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select "
									+ "B.board_no, B.board_header, B.board_writer, B.board_title, B.board_content, "
									+ "B.board_read, B.board_time, "
									+ "count(R.reply_no) reply_count "
								+ "from "
								+ "board B left outer join reply R on B.board_no = R.reply_origin "
								+ "where instr(#1, ?) > 0 "
								+ "group by "
									+ "B.board_no, B.board_header, B.board_writer, B.board_title, B.board_content, "
									+ "B.board_read, B.board_time "
								+ "order by B.board_no desc "
							+ ")TMP "
						+ ") where rn between ? and ?";
		Object[] param = {key, startRow, endRow};
		return jdbcTemplate.query(sql, param, voMapper);
	}
	
	
}