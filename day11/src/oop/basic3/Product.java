package oop.basic3;

//상품 클래스 = 상품코드 + 상품이름 + 상품분류 + 판매가격
public class Product {
	String code;
	String name;
	String type;
	int price;
	
	//초기화 메소드
	void info(String code, String name, String type, int price) {
		this.code = code; 
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	//설정 메소드
	void print() {
		System.out.println("상품코드 : "+this.code);
		System.out.println("상품이름 : "+this.name);
		System.out.println("상품분류 : "+this.type);
		System.out.println("판매가격 : "+this.price+"원");
	}
}
