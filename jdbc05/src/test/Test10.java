package test;

import beans.MemberDao;

public class Test10 {
	public static void main(String[] args) throws Exception {
		//member테이블 삭제 구현
		
		//데이터 준비(DTO 생략)
		int member_no = 1;
		
		//처리(DAO)
		MemberDao dao = new MemberDao();
		boolean result = dao.delete(member_no);
		
		if(result) {
			System.out.println("탈퇴가 완료되었습니다");
		}
		else {
			System.out.println("해당 회원은 존재하지 않습니다");
		}
	}
}