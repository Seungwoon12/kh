package oop.basic3;

public class Test01 {
	public static void main(String[] args) {
		
		Market p1 = new Market();
		Market p2 = new Market();
		Market p3 = new Market();
		
		p1.info("A00001", "참이슬", "주류", 1200);
		p2.info("A00002", "처음처럼", "주류", 1300);
		p3.info("B00001", "고무장갑", "생필품", 2000);
		
		p1.print();
		p2.print();
		p3.print();
		
	}
}