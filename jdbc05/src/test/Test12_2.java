package test;

import java.sql.SQLException;
import java.util.List;

import beans.PersonDao;
import beans.PersonDto;

public class Test12_2 {
	public static void main(String[] args) throws Exception {
		//person 테이블의 모든 데이터를 조회하여 출력
		
		//데이터 준비(없음)
		
		//조회
		PersonDao dao = new PersonDao();
		List<PersonDto> list = dao.select();
		
		System.out.println("개수 : "+list.size());
		
		for(PersonDto dto : list) {
			System.out.println("번호 : "+dto.getPerson_no());
			System.out.println("이름 : "+dto.getPerson_name());
		}
	}
}