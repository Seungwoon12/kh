package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test07 {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "web", "web");
			
			String sql = "select "
					+ "type, count(*) 수량, avg(price) 평균판매가, max(price) 최고가  "
					+ "from product group by type";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				System.out.print(rs.getString("type")+"/");
				System.out.print(rs.getInt("수량")+"/");
				System.out.print(rs.getInt("평균판매가")+"/");
				System.out.print(rs.getInt("최고가")+"\n");
			}
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
