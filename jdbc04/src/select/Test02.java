package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test02 {
	public static void main(String[] args) {
		//SELECT를 이해해보자
		//- 사용할 명령 : select * from student;
		
		//- 예상 결과
		//피카츄/60
		//파이리/60
		//...(데이터 개수만큼 출력)...
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			
			String sql = "select * from student";
			PreparedStatement ps = con.prepareStatement(sql);
			//실행한 뒤 결과집합(ResultSet)에 접근할 수 있는 기능을 가진 객체(rs)를 얻어내는 명령
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("name")); //첫번째 컬럼을  꺼내라
				System.out.println(rs.getInt("score")); // 두번째 컬럼을 꺼내라
			}
		
			
			con.close();
			System.out.println("조회완료!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}