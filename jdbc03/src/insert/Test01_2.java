package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test01_2 {
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
		
		// 정적 SQL 방식 : 구문과 값을 있는 그대로 합쳐서 전송 (이걸로 하면 안됨)
		// 동적 SQL 방식 : 구문은 그대로 두고 값을 변조시켜 합친 뒤 전송
		
		
		// - 정적 SQL 처리 방식
		// - 문제점 : 특수문자 오류 발생 가능, SQL 인젝션 공격 가능(강제 구문 삽입 공격)
		
		
		//3.명령 준비 및 전송
		// - 동적 SQL 처리 방식으로!
		// - PreparedStatement에 존재하는 "값 채우기 기능"을 사용하여 변조된 값을 삽입
		// - 장점 : 구문과 값이 구분되어 기존의 오류가 발생하지 않는다. SQL인젝션 공격을 당하지 않는다.
		// - 단점 : 어렵다. 상상력이 많이 필요하다.
		String sql = "insert into person values("
				+ "person_seq.nextval, ?, 100, 99, '여자', sysdate)";
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, person_name); //ps님! 1번째 물음표에 person_name을 String 형태로 알아서 채워주세요!
		ps.execute();
		
		//커밋을 안해도 기본적으로 자동커밋이 되도록 설정되어 있다
		// - 수동 커밋으로 변경하면 내가 직접 커밋을 실행할 수 있다
		
		//4.종료
		con.close();
		System.out.println("성공!");
	}
}