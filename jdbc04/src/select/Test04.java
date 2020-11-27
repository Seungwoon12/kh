package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//사용자에게 이름을 입력받아 해당하는 이름의 사람을 조회
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요!");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			
			
			String name = sc.nextLine();
			String sql = "select * from person where person_name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			int count = 0;
			while(rs.next()) {
				System.out.print(rs.getInt("person_no")+" "+"/ ");
				System.out.print(rs.getString("person_name")+" "+"/ ");
				System.out.print(rs.getInt("javascore")+" "+"/ ");
				System.out.print(rs.getInt("dbscore")+" "+"/ ");
				System.out.print(rs.getString("gender")+" "+"/ ");
				System.out.print(rs.getDate("join_date")+"\n");
				count++;
				
			}
			if(count == 0) {
				System.out.println("검색결과가 존재하지 않습니다.");
			}
			else {
				System.out.println("총 "+count+"개의 결과가 조회되었습니다.");
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
