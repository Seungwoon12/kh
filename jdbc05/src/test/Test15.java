package test;

import java.util.List;

import beans.PersonDao;
import beans.PersonDto;

public class Test15 {
	public static void main(String[] args) throws Exception {
		//person 테이블의 데이터를 검색
		
		//데이터 준비
		String person_name = "자바왕";
		
		//데이터 검색(DB)
		PersonDao dao = new PersonDao();
		List<PersonDto> list = dao.search(person_name);
		
		//출력
		for(PersonDto dto : list) {
			System.out.println(dto.getPerson_no());
			System.out.println(dto.getPerson_name());
			System.out.println(dto.getJavascore());
			System.out.println(dto.getDbscore());
			System.out.println(dto.getGender());
			System.out.println(dto.getRegist_date());
		}
	}
}
