package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	//등록 기능
	public void write(BoardDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		
		String sql = "insert into board("
						+ "board_no, board_writer, board_header, board_title, board_content"
					+ ") values(board_seq.nextval, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getBoard_writer());
		ps.setString(2, dto.getBoard_header());
		ps.setString(3, dto.getBoard_title());
		ps.setString(4, dto.getBoard_content());
		ps.execute();
		
		con.close();
	}
	
	//목록
	public List<BoardDto> select() throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		
		String sql = "select * from board order by board_no desc";
//		String sql = "select * from board order by board_time desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<BoardDto> list = new ArrayList<>();
//		List<BoardDto> list = new LinkedList<>();
//		List<BoardDto> list = new CopyOnWriteArrayList<>();
		while(rs.next()) {
			BoardDto dto = new BoardDto();
			dto.setBoard_no(rs.getInt("board_no"));
			dto.setBoard_writer(rs.getString("board_writer"));
			dto.setBoard_header(rs.getString("board_header"));
			dto.setBoard_title(rs.getString("board_title"));
			dto.setBoard_content(rs.getString("board_content"));
			dto.setBoard_read(rs.getInt("board_read"));
			dto.setBoard_time(rs.getDate("board_time"));
			list.add(dto);
		}
		
		con.close();
		
		return list;
	}
	
	//1차검색 - keyword라는 값으로 제목 유사검색 진행
	public List<BoardDto> select(String keyword) throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		
		String sql = "select * from board "
						+ "where instr(board_title, ?) > 0 "
						+ "order by board_no desc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		//목록과 동일한 코드
		List<BoardDto> list = new ArrayList<>();
		while(rs.next()) {
			BoardDto dto = new BoardDto();
			dto.setBoard_no(rs.getInt("board_no"));
			dto.setBoard_writer(rs.getString("board_writer"));
			dto.setBoard_header(rs.getString("board_header"));
			dto.setBoard_title(rs.getString("board_title"));
			dto.setBoard_content(rs.getString("board_content"));
			dto.setBoard_read(rs.getInt("board_read"));
			dto.setBoard_time(rs.getDate("board_time"));
			list.add(dto);
		}
		
		con.close();
		
		return list;
		
	}
	
	//2차검색 - type에 들어있는 분류와 keyword라는 검색어로 유사검색 진행
	//ex : type="board_title" 이고 keyword가 "a"라면 다음과 같은 구문이 실행
	// - select * from board where instr(board_title, "a") > 0 order by board_no desc
	//ex : type="board_writer" 이고 keyword가 "a"라면 다음과 같은 구문이 실행
	// - select * from board where instr(board_writer, "a") > 0 order by board_no desc
	public List<BoardDto> select(String type, String keyword) throws Exception {
		
		Connection con = JdbcUtil.getConnection("web", "web");
		
		//방법1 : 연결 연산으로 직접 구문을 제작하는 형태
		//String sql = "select * from board where instr("+type+", ?) > 0 order by board_no desc";
		//PreparedStatement ps = con.prepareStatement(sql);
		//ps.setString(1, keyword);
		//ResultSet rs = ps.executeQuery();
		
		//방법2 : 문자열의 replace() 를 사용
		String sql = "select * from board where instr(#1, ?) > 0 order by board_no desc";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		//목록과 동일한 코드
		List<BoardDto> list = new ArrayList<>();
		while(rs.next()) {
			BoardDto dto = new BoardDto();
			dto.setBoard_no(rs.getInt("board_no"));
			dto.setBoard_writer(rs.getString("board_writer"));
			dto.setBoard_header(rs.getString("board_header"));
			dto.setBoard_title(rs.getString("board_title"));
			dto.setBoard_content(rs.getString("board_content"));
			dto.setBoard_read(rs.getInt("board_read"));
			dto.setBoard_time(rs.getDate("board_time"));
			list.add(dto);
		}
		
		con.close();
		
		return list;
	}
	
	public BoardDto  find(int board_no) throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		
		String sql = "select * from board where board_no = ?	";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, board_no);
		ResultSet rs = ps.executeQuery();
		
		BoardDto dto;
		if(rs.next()) {
			dto = new BoardDto();
			dto.setBoard_no(rs.getInt("board_no"));
			dto.setBoard_writer(rs.getString("board_writer"));
			dto.setBoard_header(rs.getString("board_header"));
			dto.setBoard_title(rs.getString("board_title"));
			dto.setBoard_content(rs.getString("board_content"));
			dto.setBoard_read(rs.getInt("board_read"));
			dto.setBoard_time(rs.getDate("board_time"));
		}
		else {
			dto = null;
		}
		
		con.close();
		
		return dto;
		
	}
	
	public boolean update(BoardDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		
		String sql = "update board "
						+ "set board_header=?, board_title=?, board_content=? "
						+ "where board_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getBoard_header());
		ps.setString(2, dto.getBoard_title());
		ps.setString(3, dto.getBoard_content());
		ps.setInt(4, dto.getBoard_no());
		int count = ps.executeUpdate();
		
		con.close();
		return count > 0;
//		if(count > 0) {
//			return true;
//		}
//		else {
//			return false;
//		}
	}
	
	
	public int newNo() throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		String sql = "select max(board_no) from board";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int no;
		if(rs.next()) {
			no = rs.getInt("max(board_no)");
		}
		else {
			no = 0;
		}
		
		return no;
	}
	
	public boolean delete(int board_no) throws Exception {
		Connection con = JdbcUtil.getConnection("web", "web");
		
		String sql = "delete board where board_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, board_no);
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
}