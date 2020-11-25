package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01 {
	public static void main(String[] args) {
		//데이터 준비
		int person_no = 1;
		int javascore = 60;
		int dbscore = 50;
		
		//수정
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			//con.setAutoCommit(false);//수동 커밋 모드로 설정
			
			String sql = "update person set javascore=?, dbscore=? where person_no=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, javascore);
			ps.setInt(2, dbscore);
			ps.setInt(3, person_no);
			ps.execute();
			
			//con.commit();//커밋을 실행하라!
			con.close();
			System.out.println("수정 성공");
		}
		catch(Exception e) {
			e.printStackTrace();//예외 메세지를 화면에 출력(처리 안한거처럼... 개발자용)
		}
	}
}