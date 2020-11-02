package oop.method3;
//휴대전화 = 이름 + 통신사 + 판매가 + 약정개월
public class Phone {
	String name;
	String telecom;
	int price;
	int month;
	
	void setName(String name) {
		this.name = name;
	}
	void setTelecom(String telecom) {
		this.telecom = telecom;
	}
	void setPrice(int price) {
		if(price < 0) {
			return;//메소드 실행 중지
		}
		this.price = price;
	}
	void setMonth(int month) {
		switch(month) {
		case 24: case 30: case 36:
			this.month = month;
		}
	}
	
	void info(String name, String telecom, int price, int month) {
		this.setName(name);//내가 가진 setName메소드를 호출
		this.setTelecom(telecom);//내가 가진 setTelecom메소드를 호출
		this.setPrice(price);//내가 가진 setPrice메소드를 호출
		this.setMonth(month);//내가 가진 setMonth메소드를 호출
	}
	
	void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("통신사 : "+this.telecom);
		System.out.println("가격 : "+this.price);
		System.out.println("약정개월 : "+this.month);
	}
}