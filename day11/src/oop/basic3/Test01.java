package oop.basic3;

public class Test01 {
	public static void main(String[] args) {
		//상품 객체 생성
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		//정보 초기화
		p1.info("A00001", "참이슬", "주류", 1200);
		p2.info("A00002", "처음처럼", "주류", 1300);
		p3.info("B00001", "고무장갑", "생필품", 2000);
		
		//정보 출력
		p1.print();
		p2.print();
		p3.print();
	}
}
