package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.PersonDao;
import beans.PersonDto;
import util.JdbcUtil;

public class Test06_2 {
	public static void main(String[] args) throws Exception {
		//DAO, DTO를 활용한 데이터 구조화
		
		//데이터 준비(5개 : 4개 수정 + 1개 PK)
		PersonDto dto = new PersonDto();
		dto.setPerson_no(10);
		dto.setPerson_name("아무개");
		dto.setJavascore(55);
		dto.setDbscore(66);
		dto.setGender("여자");
		
		//데이터 수정(update)
		PersonDao dao = new PersonDao();
		boolean success = dao.update(dto);
		
		System.out.println("처리결과 : "+success);
	}
}
