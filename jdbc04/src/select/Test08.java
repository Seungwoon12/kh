package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test08 {
	public static void main(String[] args) {
		// 목표 : select count(*) from person 을 자바에서 실행한 뒤 결과 출력
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			
			String sql = "select count(*) CNT from person";
			PreparedStatement ps = con.prepareStatement(sql);
			// 주의 : count(*) 처럼 숫자 하나만 나오는 경우라도 결과집합을 사용한다
			ResultSet rs = ps.executeQuery();
			
			// 주의 : count는 무조건 결과가 1개 나온다.
			
			rs.next();
			System.out.println(rs.getInt("CNT"));
			
			
			con.close();
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
