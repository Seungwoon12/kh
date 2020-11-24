package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("oracle.jdbc.OracleDriver"); //준비
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle"); //연결
		con.close(); //종료
		System.out.println("완료");
		
		
	}
}
