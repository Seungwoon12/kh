package oop.final2;

public class Test01 {
	public static void main(String[] args) {
		Member a = new Member("master", "1234", "운영자");
		Member b = new Member("user", "5555");
		
//		a.setId("admin");//a의 id를 admin로 변경(말이 안됨)
		a.setPassword("2345");//a의 비밀번호를 2345로 변경
		a.setNickname("테스트");
	}
}
