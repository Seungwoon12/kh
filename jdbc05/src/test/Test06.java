package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JdbcUtil;

public class Test06 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int person_no = 10;
		String person_name = "고친이름";
		int javascore = 99;
		int dbscore = 99;
		String gender = "남자";
		
		//
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "update person set person_name=?, javascore=?, dbscore=?, gender=? "
				+ "where person_no=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, person_name);
		ps.setInt(2, javascore);
		ps.setInt(3, dbscore);
		ps.setString(4, gender);
		ps.setInt(5, person_no);
		
		ps.execute();
		
		con.close();
		
		
				
	}
}
