package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcUtil;

public class Test12 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//person 테이블의 모든 데이터를 조회하여 출력
		
		//데이터 준비(없음)
		
		//조회
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "select * from person";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();//select용 명령
		
		while(rs.next()) {
			System.out.println("번호 : "+rs.getInt("person_no"));
			System.out.println("이름 : "+rs.getString("person_name"));
			System.out.println("자바 : "+rs.getInt("javascore"));
			System.out.println("DB : "+rs.getInt("dbscore"));
			System.out.println("성별 : "+rs.getString("gender"));
			System.out.println("가입일 : "+rs.getDate("regist_date"));
		}
		
		con.close();
		
	}
}
