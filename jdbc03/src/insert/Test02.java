package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//데이터는 미리 준비해둬야 한다.
		System.out.println("정보 입력");
		Scanner sc = new Scanner(System.in);
		String person_name = sc.nextLine();
		int javascore = sc.nextInt();
		int dbscore = sc.nextInt();
		String gender = sc.next();
		sc.close();
		
		//등록 코드
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
		
		String sql = "insert into person values(person_seq.nextval, ?, ?, ?, ?, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, person_name);
		ps.setInt(2, javascore);
		ps.setInt(3, dbscore);
		ps.setString(4, gender);
		ps.execute();
		
		con.close();
		System.out.println("성공");
	}
}