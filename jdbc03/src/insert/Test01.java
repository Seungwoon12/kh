package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.준비
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.연결
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
		
		//3.명령 준비 및 전송
		String sql = "insert into person values("
				+ "person_seq.nextval, '자바왕', 100, 99, '여자', sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		
		//커밋을 안해도 기본적으로 자동커밋이 되도록 설정되어 있다
		// - 수동 커밋으로 변경하면 내가 직접 커밋을 실행할 수 있다
		
		//4.종료
		con.close();
		System.out.println("성공!");
	}
}