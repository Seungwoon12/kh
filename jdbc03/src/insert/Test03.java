package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//전체 항목 중 아이디,비밀번호,닉네임,생년월일만 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력");
		String member_id = sc.nextLine();
		System.out.println("비밀번호 입력");
		String member_pw = sc.nextLine();
		System.out.println("닉네임 입력");
		String member_nick = sc.nextLine();
		System.out.println("생년월일 입력");
		String member_birth = sc.nextLine();
		sc.close();
		
		//데이터베이스 등록
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "web", "web");
		
//		String sql = "insert into member values("
//						+ "member_seq.nextval, ?, ?, ?, ?, '일반', 0, sysdate)";
		String sql = "insert into member("
				+ "member_no, member_id, member_pw, member_nick, member_birth, member_auth) "
				+ "values(member_seq.nextval, ?, ?, ?, ?, '일반')";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member_id);
		ps.setString(2, member_pw);
		ps.setString(3, member_nick);
		ps.setString(4, member_birth);
		ps.execute();
		
		con.close();
		System.out.println("회원 가입 완료!");
	}
}