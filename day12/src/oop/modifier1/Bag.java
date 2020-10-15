package oop.modifier1;

public class Bag {
	private String name;
	private int price;
	
	void setName(String name) {
		this.name = name;
	}
	void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
	}
	
	void info(String name, int price) {
		this.setName(name);
		this.setPrice(price);
	}
	
}
