package test;

import beans.MemberDao;
import beans.MemberDto;

public class Test07 {
	public static void main(String[] args) throws Exception {
		//member 수정 코드 구현
		
		//데이터 준비
		MemberDto dto = new MemberDto();
		dto.setMember_id("student");
		dto.setMember_pw("study1234");
		dto.setMember_nick("학생");
		dto.setMember_birth("2020-01-01");
		dto.setMember_no(1);
		
		//처리
		MemberDao dao = new MemberDao();
		boolean result = dao.update(dto);
		
		//결과 출력
		if(result) {
			System.out.println("수정 완료!");
		}
		else {
			System.out.println("수정 실패!");
		}
	}
}