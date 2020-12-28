package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;

//PersonDao는 Person테이블에 대해서 일을 하는 Dao이다.
//DAO는 Data Access Object의 줄임말로 DB 관련된 작업을 처리하는 역할의 클래스(창고지기)
public class PersonDao {

	//등록 메소드
	//- 등록을 하려면 사용자가 이름, 자바점수, DB점수, 성별을 입력해야 한다(프로그램이 할 수 없는 것) : 매개변수
	//- 등록을 마치면 사용자에게 알려줄 정보가 없다 : 반환형
	public void insert(String person_name, int javascore, int dbscore, String gender) throws Exception{
		Connection con = JdbcUtil.getConnection("kh", "kh");
		String sql = "insert into person values(person_seq.nextval, ?, ?, ?, ?, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, person_name);
		ps.setInt(2, javascore);
		ps.setInt(3, dbscore);
		ps.setString(4, gender);
		ps.execute();
		con.close();
	}
	
	//등록 메소드(한덩어리로 등록)
	public void insert(PersonDto dto) throws Exception{
		Connection con = JdbcUtil.getConnection("kh", "kh");
		String sql = "insert into person values(person_seq.nextval, ?, ?, ?, ?, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getPerson_name());//dto의 person_name에 들어있는 값을 설정
		ps.setInt(2, dto.getJavascore());//dto의 javascore에 들어있는 값을 설정
		ps.setInt(3, dto.getDbscore());//dto의 dbscore에 들어있는 값을 설정
		ps.setString(4, dto.getGender());//dto의 gender에 들어있는 값을 설정
		ps.execute();
		con.close();
	}
	
	//수정 메소드
	//- PersonDto를 전달받아 수정을 하고 반환은 없다(void)
	//public void update(PersonDto dto) throws Exception {//성공실패를 알 수 없다
	
	//- PersonDto를 전달받아 수정을 하고 성공/실패를 반환한다(boolean)
	public boolean update(PersonDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "update person "
						+ "set person_name=?, javascore=?, dbscore=?, gender=? "
						+ "where person_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getPerson_name());
		ps.setInt(2, dto.getJavascore());
		ps.setInt(3, dto.getDbscore());
		ps.setString(4, dto.getGender());
		ps.setInt(5, dto.getPerson_no());
		int result = ps.executeUpdate();//결과 행 수를 알기 위한 실행구문
		
		con.close();
		
		if(result > 0) {//수정된 행이 1개 이상이라면
			return true;//성공을 반환해라
		}
		else {//아니면
			return false;//실패를 반환해라
		}
	}
	
	//삭제 메소드
	//회원 번호(int)를 전달받아 삭제한 뒤 성공/실패(boolean)를 반환한다
	public boolean delete(int person_no) throws Exception {
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "delete person where person_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, person_no);
		int count = ps.executeUpdate();
		
		con.close();
		
		return count > 0;//count가 0보다 큰지 여부를 반환하세요!
	}
	
	//조회 메소드
	//- 회원 목록(List<PersonDto>)을 반환한다
	public List<PersonDto> select() throws Exception {
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "select * from person";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();//select용 명령
		
		//rs는 연결 끊어지면 사용이 불가능해서 원하는 시점에 원하는 장소에 출력하기가 매우 어렵다
		//기왕 이렇게 된거 rs에 들어있는 데이터를 연결 끊어지기 전에 List<PersonDto>로 변환하자!
		//1. 비어있는 List를 준비한다.
		List<PersonDto> list = new ArrayList<>();
		
		//2. 데이터 개수만큼 압축하여 List에 추가한다.
		while(rs.next()) {
			PersonDto dto = new PersonDto();//비어있는 객체를 생성
			//int person_no = rs.getInt("person_no");//rs에서 person_no를 꺼내라!
			//dto.setPerson_no(person_no);//dto에 person_no를 넣어라!
			dto.setPerson_no(rs.getInt("person_no"));//person_no를 rs에서 dto로 옮겨라!
			dto.setPerson_name(rs.getString("person_name"));//person_name을 rs에서 dto로 옮겨라!
			dto.setJavascore(rs.getInt("javascore"));//javascore를 rs에서 dto로 옮겨라!
			dto.setDbscore(rs.getInt("dbscore"));//dbscore를 rs에서 dto로 옮겨라!
			dto.setGender(rs.getString("gender"));//gender를 rs에서 dto로 옮겨라!
			dto.setRegist_date(rs.getDate("regist_date"));//regist_date를 rs에서 dto로 옮겨라!
			
			//정보가 담긴 dto를 list에 추가해라!
			list.add(dto);
		}
		
		con.close();
		
		//준비완료된 목록을 반환하겠다!
		return list;
	}
	
	//이름(person_name)을 조회하는 메소드
	// - 이름(String) 전달받아서 조회한 뒤 사람 목록(List<PersonDto>)를 반환
	public List<PersonDto> search(String person_name) throws Exception {
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		//String sql = "select * from person where person_name = ?";
		String sql = "select * from person where instr(person_name, ?) > 0";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, person_name);
		ResultSet rs = ps.executeQuery();
		
		//어짜피 목록이나 검색이나 변환 과정은 같다(데이터가 많냐 적냐의 차이)
		List<PersonDto> list = new ArrayList<>();
		while(rs.next()) {
			PersonDto dto = new PersonDto();
			dto.setPerson_no(rs.getInt("person_no"));
			dto.setPerson_name(rs.getString("person_name"));
			dto.setJavascore(rs.getInt("javascore"));
			dto.setDbscore(rs.getInt("dbscore"));
			dto.setGender(rs.getString("gender"));
			dto.setRegist_date(rs.getDate("regist_date"));
			list.add(dto);
		}
		
		con.close();
		
		return list;//목록 반환
	}

	//자바점수(javascore)를 조회하는 메소드
	// - 자바점수(int) 전달받아서 조회한 뒤 사람 목록(List<PersonDto>)를 반환
	public List<PersonDto> search(int javascore) throws Exception {
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "select * from person where javascore = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, javascore);
		ResultSet rs = ps.executeQuery();
		
		//이 뒤는 목록, 다른 검색과 동일하다.
		// - 비어있는 리스트 준비하고, 한줄씩 PersonDto에 옮겨서 List에 추가한다.
		List<PersonDto> list = new ArrayList<>();
		while(rs.next()) {
			PersonDto dto = new PersonDto();
			dto.setPerson_no(rs.getInt("person_no"));
			dto.setPerson_name(rs.getString("person_name"));
			dto.setJavascore(rs.getInt("javascore"));
			dto.setDbscore(rs.getInt("dbscore"));
			dto.setGender(rs.getString("gender"));
			dto.setRegist_date(rs.getDate("regist_date"));
			list.add(dto);
		}
		
		con.close();
		
		return list;//목록 반환
	}
}
