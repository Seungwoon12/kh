package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test05_1 {
	public static void main(String[] args) {
		//검색어와 "유사한 이름"을 가지는 데이터를 조회
		// - LIKE %
		// - INSTR 함수 = INSTR() 괄호가 있으면 함수 그래서 함수면 괄호 무조건 써야함
		// - LIKE로 한거
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요!");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			
			
			String keyword = sc.next();
//			String sql = "select * from person where instr(person_name, ?) > 0";
			String sql = "select * from person where person_name like '%'||?||'%'"; // like로 할 때 주의하기 ?는 문자열이라 자동으로 따옴표가 생성되는거임
					
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, keyword);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("person_no")+" "+"/ ");
				System.out.print(rs.getString("person_name")+" "+"/ ");
				System.out.print(rs.getInt("javascore")+" "+"/ ");
				System.out.print(rs.getInt("dbscore")+" "+"/ ");
				System.out.print(rs.getString("gender")+" "+"/ ");
				System.out.print(rs.getDate("join_date"));
				System.out.println();
			}
			
			con.close();
			sc.close();
			System.out.println("연결 종료!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
