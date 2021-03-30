package mvc.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mvc.beans.JdbcUtil;

public class BoardDao {
	
	public static final String USERNAME = "web";
	public static final String PASSWORD = "web";
	
	//등록 기능
	public void write(BoardDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
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
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
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
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
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
		
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
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
	
	//상세보기(단일조회)
	public BoardDto find(int board_no) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select * from board where board_no = ?";//결과가 절대로 여러개가 나올 수 없다
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, board_no);
		ResultSet rs = ps.executeQuery();
		
		//rs는 예상 결과가 1개 아니면 0개. 즉 있냐 없냐만 알면 된다.
		//목록처럼 List를 만들어서 add를 할 필요가 없다(while문이 필요 없다)
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
		
		con.close();
		
		return dto;
	}
	
	//수정 기능
	public boolean update(BoardDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
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
	
//	삭제 기능
	public boolean delete(int board_no) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "delete board where board_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, board_no);
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;
	}
	
	
//	시퀀스 번호를 미리 생성하는 기능
	public int getSequence() throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();//무조건 나옴
		int seq = rs.getInt(1);
//		int seq = rs.getInt("NEXTVAL");
		
		con.close();
		return seq;
	}
	
//	번호까지 함께 등록하는 기능
	public void writeWithPrimaryKey(BoardDto boardDto) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "insert into board values(?, ?, ?, ?, ?, 0, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardDto.getBoard_no());
		ps.setString(2, boardDto.getBoard_writer());
		ps.setString(3, boardDto.getBoard_header());
		ps.setString(4, boardDto.getBoard_title());
		ps.setString(5, boardDto.getBoard_content());
		ps.execute();
		
		con.close();
	}
	
//	조회수 증가 기능 : 성공/실패를 반환할 필요가 없음
	public void plusReadcount(int board_no) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "update board set board_read=board_read+1 where board_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, board_no);
		
		ps.execute();
//		int count = ps.executeUpdate();
		
		con.close();
	}
	
//	페이징을 이용한 검색
	public List<BoardDto> pagingList(String type, String key, int startRow, int endRow) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = 	"select * from(" + 
							"select rownum rn, TMP.* from(" + 
								"select * from board "
								+ "where instr(#1, ?) > 0 "
								+ "order by board_no desc" + 
							")TMP" + 
						") where rn between ? and ?";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, key);
		ps.setInt(2, startRow);
		ps.setInt(3, endRow);
		ResultSet rs = ps.executeQuery();
		
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
	
//	페이징을 이용한 목록
	public List<BoardDto> pagingList(int startRow, int endRow) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = 	"select * from(" + 
							"select rownum rn, TMP.* from(" + 
								"select * from board order by board_no desc" + 
							")TMP" + 
						") where rn between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, startRow);
		ps.setInt(2, endRow);
		ResultSet rs = ps.executeQuery();
		
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
	
//	검색 개수를 구하는 메소드
	public int getCount(String type, String key) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select count(*) from board where instr(#1, ?) > 0";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, key);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
//		int count = rs.getInt("count(*)");
		con.close();
		
		return count;
	}
	
//	목록 개수를 구하는 메소드
	public int getCount() throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
		String sql = "select count(*) from board";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
//		int count = rs.getInt("count(*)");
		con.close();
		
		return count;
	}
	
	
//	페이징 + 댓글개수까지 불러오는 목록 메소드
	public List<BoardReplyCountVO> pagingReplyCountList(int startRow, int endRow) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
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
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, startRow);
		ps.setInt(2, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<BoardReplyCountVO> list = new ArrayList<>();
		while(rs.next()) {
			BoardReplyCountVO vo = new BoardReplyCountVO();
			vo.setBoard_no(rs.getInt("board_no"));
			vo.setBoard_writer(rs.getString("board_writer"));
			vo.setBoard_header(rs.getString("board_header"));
			vo.setBoard_title(rs.getString("board_title"));
			vo.setBoard_content(rs.getString("board_content"));
			vo.setBoard_read(rs.getInt("board_read"));
			vo.setBoard_time(rs.getDate("board_time"));
			vo.setReply_count(rs.getInt("reply_count"));
			list.add(vo);
		}
		
		con.close();
		
		return list;
	}
	
	public List<BoardReplyCountVO> pagingReplyCountList(String type, String key, int startRow, int endRow) throws Exception {
		Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
		
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
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, key);
		ps.setInt(2, startRow);
		ps.setInt(3, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<BoardReplyCountVO> list = new ArrayList<>();
		while(rs.next()) {
			BoardReplyCountVO vo = new BoardReplyCountVO();
			vo.setBoard_no(rs.getInt("board_no"));
			vo.setBoard_writer(rs.getString("board_writer"));
			vo.setBoard_header(rs.getString("board_header"));
			vo.setBoard_title(rs.getString("board_title"));
			vo.setBoard_content(rs.getString("board_content"));
			vo.setBoard_read(rs.getInt("board_read"));
			vo.setBoard_time(rs.getDate("board_time"));
			vo.setReply_count(rs.getInt("reply_count"));
			list.add(vo);
		}
		
		con.close();
		
		return list;
	}
	
}
