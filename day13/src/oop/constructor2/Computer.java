package oop.constructor2;

public class Computer {
	//멤버 변수
	private String name;
	private int price;
	
	//생성자 : 객체를 생성하는 방법을 정하는 구문
	// = 객체를 만들 때 반드시 있어야 하는것이 무엇입니까?
	// 1.이름도 없고 가격은 없는 경우
	// 2.이름은 있는데 가격은 없는 경우(o)
	// 3.이름은 없는데 가격은 있는 경우
	// 4.이름과 가격 모두 있는 경우(o)
	public Computer(String name) {
		this.setName(name);
		this.setPrice(0);
	}
	public Computer(String name, int price) {
		this.setName(name);
		this.setPrice(price);
	}
	
	//setter&getter
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
}