package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test03 {
	public static void main(String[] args) {
		//select를 통해 자바에서 ResultSet(결과집합)을 얻어내야 한다.
		
		//Person테이블을 조회하세요
		
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");	
					
				String sql = "select * from person";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
					
				while(rs.next()) {
					System.out.println(rs.getInt("person_no"));
					System.out.println(rs.getString("person_name"));
					System.out.println(rs.getInt("javascore"));
					System.out.println(rs.getInt("dbscore"));
					System.out.println(rs.getString("gender"));
					System.out.println(rs.getString("join_date")); 
					System.out.println(rs.getDate("join_date"));	//getString, getDate 둘 다 가능					System.out.println();
				}
					
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}
