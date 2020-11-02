package oop.constructor3;

public class Test01 {
	public static void main(String[] args) {
		//정보가 담긴 객체 생성
		Player p1 = new Player("뽀로로", "전사", 15, 300);
//		Player p2 = new Player("피카츄", "마법사", 1, 0);
		Player p2 = new Player("피카츄", "마법사");
		Player p3 = new Player("타요", "전사", 10, 250);
		
		p1.print();
		p2.print();
		p3.print();
	}
}