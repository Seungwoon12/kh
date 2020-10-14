package oop.basic4;

public class Menu {
	
	String name;
	String category;
	int price;
	char sale;
	
	
	void info(String a, String b, int c, char d) {
		this.name = a;
		this.category = b;
		this.price = c;
		this.sale = d;
	}
	
				
	void print() {
		if(this.sale == 'O') {
			this.price -= 500;
		}
		System.out.println("이름 : "+this.name);
		System.out.println("분류 : "+this.category);
		System.out.println("판매가격 : "+this.price);
		System.out.println("행사여부 : "+this.sale);
	}
}