package oop.method3;

public class Phone {
	String name;
	String service;
	int price;
	int monthly;
	
	
	void setName(String name) {
		this.name = name;
	}
	
	void setService(String service) {
		this.service = service;
	}
	
	void setPrice(int price) {
		if(price < 0) {
			return; //메소드 실행 중지
		}
		this.price = price;
	}
	
	void setMonthly(int monthly) {
		if(monthly == 24 || monthly == 30 || monthly == 36) {
			this.monthly = monthly;
		}
		else {
			monthly = 0;
		}
		
		
	}
	
	void info(String name, String service, int price, int monthly) {
		this.setName(name);
		this.setService(service);
		this.setPrice(price);
		this.setMonthly(monthly);
	}
	
	
	void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("통신사 : "+this.service);
		System.out.println("가격 : "+this.price+"원");
		if(monthly == 0) {
			System.out.println("약정개월수 : "+"일시불");
		}
		else {
			System.out.println("약정개월수 : "+this.monthly+"개월");
		}
	}
}
