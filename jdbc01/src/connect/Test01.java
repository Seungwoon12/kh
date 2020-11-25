package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//JDBC(Java DataBase Connectivity)
		// - Java에서 Database에 연결하기 위한 모든 형태의 작업
		// - Database는 oracle인데.. java에서 이 정보를 알아야 한다.
		// - Oracle에서 제공하는 자바를 위한 라이브러리를 등록해야 한다.(ojdbc.jar) / 수업에서는 ojdbc8.jar 필요
		// - 프로젝트 우클릭 build path -> configure build path 클릭
		
		//오라클에 연결을 하기 위한 과정
		// 1. 연결을 준비한다. (오라클에서 제공하는 준비 도우미를 호출)
		// 2. 연결을 실행한다. (로그인 - 아이디/비밀번호/+접속주소)
		// 3. 연결을 종료한다. (명령 실행)
		
		//1.
		Class.forName("oracle.jdbc.OracleDriver");
		
		System.out.println("준비 성공!");
		
		//2. 주소, 계정, 비밀번호
		// jdbc:oracle:thin: 연결을 위해 사용되는 도구의 종류(드라이버 종류)
		// localhost : 데이터베이스의 위치(IP)
		// 1521 : 데이터베이스 접속 포트(Port)
		// xe : 데이터베이스 SID(식별자)
		Connection con = DriverManager.getConnection(  // Connection을 붙이는 이유는 jdbc에 이름을 붙이기 위해
				"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
		System.out.println("로그인 성공!");
		
		//3. 
		con.close();
		System.out.println("로그아웃 성공!");
		
	}
}
