package oop.constructor2;

public class Computer {
	//멤버 변수
	
	private String name;
	private int price;
	
	//생성자 : 객체를 생성하는 방법을 정하는 구문
	public Computer(String name) {
		this.setName(name);
		this.setPrice(0);
	}
	public Computer(String name, int price) {
			this.setName(name);
			this.setPrice(price);
			}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
}
