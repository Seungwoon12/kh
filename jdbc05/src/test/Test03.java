package test;

import beans.PersonDao;
import beans.PersonDto;

public class Test03 {
	public static void main(String[] args) throws Exception {
		//사람 정보를 데이터베이스에 등록하는 코드
		PersonDto dto = new PersonDto();
		dto.setPerson_name("테스트");
		dto.setJavascore(90);
		dto.setDbscore(80);
		dto.setGender("여자");
		
		PersonDao dao = new PersonDao();
		dao.insert(dto);
	}
}