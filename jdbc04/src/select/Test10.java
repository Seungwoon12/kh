package select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JdbcUtil;

public class Test10 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//미리 만들어둔 메소드를 불러서 연결을 생성한다.
		try {
			
			Connection con = JdbcUtil.getConnection();
			
			String sql = "select * from person";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("person_name"));
			}
			
//			rs.close(); // 생략가능
//			ps.close(); // 생략가능
			con.close(); // con을 닫으면 ps와 rs는 자동으로 닫힘
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}
}

