package oop.basic3;

public class Market {

	String code;
	String name;
	
	String category;
	int price;
	
	void info(String code, String name, String category, int price) {
		
		this.code = code;   //this가 있기 때문에 명칭 동일하게 해도 오류안뜸(헷갈림 방지하기 위해 명칭 동일하게 하는게 좋음)
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	
	void print() {
		System.out.println("상품코드 : "+this.code); // 지금 이 출력 구문에서는 this 생략은 가능함(헷갈릴만한 요소가 없기 때문에)
		System.out.println("이름 : "+this.name);
		System.out.println("분류 : "+this.category);
		System.out.println("판매가격 : "+this.price);
	}
	
}


