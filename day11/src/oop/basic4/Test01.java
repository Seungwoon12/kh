package oop.basic4;

public class Test01 {
	public static void main(String[] args) {
		
		Menu p1 = new Menu();
		Menu p2 = new Menu();
		Menu p3 = new Menu();
		
		p1.info("아메리카노", "음료", 1500, 'X');
		p2.info("카페라떼", "음료", 2000, 'O');
		p3.info("샌드위치", "식사", 3000, 'O');
		
		p1.print();
		p2.print();
		p3.print();
				
	}
}