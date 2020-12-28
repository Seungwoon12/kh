package test;

import java.util.List;

import beans.MemberDao;
import beans.MemberDto;

public class Test13 {
	public static void main(String[] args) throws Exception {
		//MemberDao를 이용한 목록 조회
		
		//데이터 준비(X)
		
		//데이터 조회
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.select();
		
		//출력
		System.out.println("회원 수 : "+list.size());
		for(MemberDto dto : list) {
			System.out.print(dto.getMember_id() + " / ");
			System.out.println(dto.getMember_pw());
		}
	}
}
