package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JdbcUtil;

public class Test09 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//일반적인 삭제는 무슨 항목으로 할까?(person 기준)
		//- 전체 삭제는 있을 수 없다
		//- 삭제는 Primary Key를 이용해서 하나씩 지운다
		//- 삭제도 성공 실패 여부를 알아야 한다
		
		//데이터 준비
		int person_no = 1;
		
		//DB 처리
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "delete person where person_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, person_no);
		int count = ps.executeUpdate();
		
		con.close();
		
		if(count > 0) {
			System.out.println("삭제가 완료되었습니다");
		}
		else {
			System.out.println("해당하는 번호에 대한 정보가 존재하지 않습니다");
		}
	}
}
