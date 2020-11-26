package delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01 {
	public static void main(String[] args) {
		//번호에 따른 사람을 삭제
		int person_no = 1;
		
		//삭제 코드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","kh","kh");
			
			String sql = "delete person where person_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, person_no);
			//ps.execute();
			int result = ps.executeUpdate();
			
			con.close();
			if(result > 0) {
				System.out.println("삭제 성공");
			}
			else {
				System.out.println("삭제 실패");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
