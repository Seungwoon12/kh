package test;

import java.sql.SQLException;

import beans.PersonDao;

public class Test09_1 {
	public static void main(String[] args) throws Exception {
		//일반적인 삭제는 무슨 항목으로 할까?(person 기준)
		//- 전체 삭제는 있을 수 없다
		//- 삭제는 Primary Key를 이용해서 하나씩 지운다
		//- 삭제도 성공 실패 여부를 알아야 한다
		
		//데이터 준비(1개밖에 없어서 DTO쓰긴 아깝다! 쓰고싶으면 써도 된다!)
		int person_no = 1;
		
		//DB 처리(DAO)
		PersonDao dao = new PersonDao();
		boolean result = dao.delete(person_no);
		
		if(result) {
			System.out.println("삭제가 완료되었습니다");
		}
		else {
			System.out.println("해당하는 번호에 대한 정보가 존재하지 않습니다");
		}
	}
}