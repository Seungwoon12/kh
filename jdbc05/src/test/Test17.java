package test;

import java.util.List;

import beans.MemberDao;
import beans.MemberDto;

public class Test17 {
	public static void main(String[] args) throws Exception {
		//닉네임 유사 검색
		
		//데이터 준비(검색어)
		String keyword = "무";
		
		//데이터 검색
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.search(keyword);
		
		//출력
		for(MemberDto dto : list) {
			System.out.println(dto.getMember_id() + " / "+dto.getMember_nick());
		}
	}
}
