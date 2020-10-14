package oop.basic3;

public class Market {

	String code;
	String name;
	String category;
	int price;
	
	void info(String a, String b, String c, int d) {
		
		this.code = a;
		this.name = b;
		this.category = c;
		this.price = d;
	}
	
	
	void print() {
		System.out.println("상품코드 : "+this.code);
		System.out.println("이름 : "+this.name);
		System.out.println("분류 : "+this.category);
		System.out.println("판매가격 : "+this.price);
	}
	
}


