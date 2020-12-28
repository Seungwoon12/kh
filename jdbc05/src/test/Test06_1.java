package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.PersonDto;
import util.JdbcUtil;

public class Test06_1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//DAO, DTO를 활용한 데이터 구조화
		
		//데이터 준비(5개 : 4개 수정 + 1개 PK)
		PersonDto dto = new PersonDto();
		dto.setPerson_no(10);
		dto.setPerson_name("고친이름");
		dto.setJavascore(90);
		dto.setDbscore(90);
		dto.setGender("남자");
		
		//데이터 수정(update)
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
		ps.execute();
		
		con.close();
		
	}
}