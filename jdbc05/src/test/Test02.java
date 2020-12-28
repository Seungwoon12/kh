package test;

import java.sql.SQLException;

import beans.PersonDao;

public class Test02 {
	public static void main(String[] args) throws Exception {
		//이전에 만든 insert 구문을  다시 살펴보고 모듈화 시킨다.
		//insert = 등록
		
		//데이터준비(사용자가 입력해야 하는 데이터만 준비)
		String person_name = "가나다";
		int javascore = 66;
		int dbscore = 85;
		String gender = "남자";
		
		//등록 구문	
		PersonDao dao = new PersonDao();
		dao.insert(person_name, javascore, dbscore, gender);
	}
}
