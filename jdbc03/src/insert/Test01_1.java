package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test01_1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력");
		String person_name = sc.nextLine();
		sc.close();
		
		//1.준비
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.연결
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
		
		//3.명령 준비 및 전송
		// - 정적 SQL 처리 방식
		// - 문제점 : 특수문자 오류 발생 가능, SQL 인젝션 공격 가능(강제 구문 삽입 공격)
		String sql = "insert into person values("
				+ "person_seq.nextval, '"+person_name+"', 100, 99, '여자', sysdate)";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.execute();
		
		//커밋을 안해도 기본적으로 자동커밋이 되도록 설정되어 있다
		// - 수동 커밋으로 변경하면 내가 직접 커밋을 실행할 수 있다
		
		//4.종료
		con.close();
		System.out.println("성공!");
	}
}