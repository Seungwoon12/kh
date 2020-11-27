package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test09_1 {
	public static void main(String[] args) {
		//Top Rank 출력 / Top N
		int start = 11;
		int finish = 15;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");	
			
//			String sql = "select * from ("
//							+ "select "
//								+ "person.*, rank() over(order by javascore+dbscore desc) rank "
//							+ "from person"
//						+ ") where rank between ? and ?";
			String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from person order by javascore+dbscore desc"
							+ ")TMP"
						+ ") where rn between ? and ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, finish);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("person_no")+"/");
				System.out.print(rs.getString("person_name")+"/");
				System.out.print(rs.getInt("javascore")+"/");
				System.out.print(rs.getInt("dbscore")+"/");
				System.out.print(rs.getInt("javascore")+rs.getInt("dbscore")+"/");
				System.out.print(rs.getString("gender")+"/");
				System.out.print(rs.getDate("join_date")+"/");
//				System.out.print(rs.getInt("rank"));
//				System.out.print(rs.getInt("rn"));
				System.out.println();
			}
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}