package test;

import java.sql.SQLException;

import beans.MemberDao;
import beans.MemberDto;

public class Test04 {
	public static void main(String[] args) throws Exception {
		//DAO, DTO없이 member테이블에 insert 하는 코드 작성
		
		//데이터 준비(8개중에 4개 준비)
		MemberDto dto = new MemberDto();
		dto.setMember_id("test6");
		dto.setMember_pw("test6");
		dto.setMember_nick("테스트6");
		dto.setMember_birth("2020-11-30");
		
		//데이터 처리(등록)
		MemberDao dao = new MemberDao();
		dao.insert(dto);
	}
}
