package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

	public void insert(PersonDto dto) throws Exception {
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "insert into person values(person_seq.nextval, ?, ?, ?, ?, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getPerson_name());
		ps.setInt(2, dto.getJavascore());
		ps.setInt(3, dto.getDbscore());
		ps.setString(4, dto.getGender());
		ps.execute();

		con.close();
	}
	
	public List<PersonDto> select() throws Exception {
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "select * from person order by person_no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
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
		
		return list;
	}
	
	//상세보기
	public PersonDto find(int person_no) throws Exception {
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "select * from person where person_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, person_no);
		ResultSet rs = ps.executeQuery();
		
		PersonDto dto;
		if(rs.next()) {
			dto = new PersonDto();
			dto.setPerson_no(rs.getInt("person_no"));
			dto.setPerson_name(rs.getString("person_name"));
			dto.setJavascore(rs.getInt("javascore"));
			dto.setDbscore(rs.getInt("dbscore"));
			dto.setGender(rs.getString("gender"));
			dto.setRegist_date(rs.getDate("regist_date"));
		}
		else {
			dto = null;
		}
		con.close();
		
		return dto;
	}
}
