package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.PersonDto;
import util.JdbcUtil;

public class Test12_1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//person 테이블의 모든 데이터를 조회하여 출력
		
		//데이터 준비(없음)
		
		//조회
		Connection con = JdbcUtil.getConnection("kh", "kh");
		
		String sql = "select * from person";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();//select용 명령
		
		//rs는 연결 끊어지면 사용이 불가능해서 원하는 시점에 원하는 장소에 출력하기가 매우 어렵다
		//기왕 이렇게 된거 rs에 들어있는 데이터를 연결 끊어지기 전에 List<PersonDto>로 변환하자!
		//1. 비어있는 List를 준비한다.
		List<PersonDto> list = new ArrayList<>();
		
		//2. 데이터 개수만큼 압축하여 List에 추가한다.
		while(rs.next()) {
			PersonDto dto = new PersonDto();//비어있는 객체를 생성
			//int person_no = rs.getInt("person_no");//rs에서 person_no를 꺼내라!
			//dto.setPerson_no(person_no);//dto에 person_no를 넣어라!
			dto.setPerson_no(rs.getInt("person_no"));//person_no를 rs에서 dto로 옮겨라!
			dto.setPerson_name(rs.getString("person_name"));//person_name을 rs에서 dto로 옮겨라!
			dto.setJavascore(rs.getInt("javascore"));//javascore를 rs에서 dto로 옮겨라!
			dto.setDbscore(rs.getInt("dbscore"));//dbscore를 rs에서 dto로 옮겨라!
			dto.setGender(rs.getString("gender"));//gender를 rs에서 dto로 옮겨라!
			dto.setRegist_date(rs.getDate("regist_date"));//regist_date를 rs에서 dto로 옮겨라!
			
			//정보가 담긴 dto를 list에 추가해라!
			list.add(dto);
		}
		
		con.close();
		
		//변환된 list에 들어있는 정보를 이용하여 원하는 작업을 수행한다.
		System.out.println("개수 : "+list.size());
		
		for(PersonDto dto : list) {
			System.out.println("번호 : "+dto.getPerson_no());
			System.out.println("이름 : "+dto.getPerson_name());
		}
	}
}
