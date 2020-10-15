package oop.method3;

public class Test01 {
	public static void main(String[] args) {
		
		Phone p1 = new Phone();
		Phone p2 = new Phone();
		Phone p3 = new Phone();
		
		p1.info("갤럭시 노트20", "SKT", 1300000, 10);	
		p2.info("아이폰12", "KT", 1700000, 36);
		p3.info("갤럭시 폴드2", "LG", 2400000, 36);
		
		
	
		
		p1.print();
		p2.print();
		p3.print();
	
		
		
	}
}
