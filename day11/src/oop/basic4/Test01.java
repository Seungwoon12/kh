package oop.basic4;

public class Test01 {
	public static void main(String[] args) {
		//객체 생성(3개)
		Menu m1 = new Menu();
		Menu m2 = new Menu();
		Menu m3 = new Menu();
		
		//정보 설정(3번)
		m1.info("아메리카노", "음료", 1500, false);
		m2.info("카페라떼", "음료", 2000, true);
		m3.info("샌드위치", "식사", 3000, true);
		
		//출력(3번)
		m1.print();
		m2.print();
		m3.print();
	}
}