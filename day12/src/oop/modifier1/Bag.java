package oop.modifier1;

//가방 클래스
public class Bag {
	//멤버변수 , 인스턴스변수 : 객체의 정보를 저장하기 위한 변수
	
	//접근제한자 : 접근을 제한하는 키워드
	//private : 인스턴스 자신만 접근 가능
	private String name;
	private int price;
	
	//멤버메소드, 인스턴스메소드 : 객체의 기능을 구현하기 위한 영역
	//setter메소드 : 변수 개수만큼
	void setName(String name) {
		this.name = name;
	}
	void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	
	//info, print
	void info(String name, int price) {
		this.setName(name);
		this.setPrice(price);
	}
	
	void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("가격 : "+this.price);
	}
}
