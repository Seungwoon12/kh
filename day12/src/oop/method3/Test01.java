package oop.method3;

public class Test01 {
	public static void main(String[] args) {
		//휴대전화 3개 생성
		Phone p1 = new Phone();
		Phone p2 = new Phone();
		Phone p3 = new Phone();
		
		//정보설정
		p1.info("갤럭시 노트20", "SKT", -300000, 22);
		p2.info("아이폰12", "KT", 1700000, 24);
		p3.info("갤럭시 폴드2", "LG", 2400000, 36);
		
		//한개씩 수정하기가 편함
		p1.setMonth(24);
		
		//출력
		p1.print();
		p2.print();
		p3.print();
	}
}