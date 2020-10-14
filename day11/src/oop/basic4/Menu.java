package oop.basic4;

public class Menu {
	
	//인스턴스변수, 멤버변수 : 객체가 사라지기 전까지 존재
		String name;
		String category;
		int price;
		boolean event;
		
		void info(String name, String category, int price, boolean event) {
			this.name = name;
			this.category = category;
			this.price = price;
			this.event = event;
		}
		
		void print() {
			System.out.println("## 메뉴 정보 ##");
			System.out.println("메뉴 이름 : "+this.name);
			System.out.println("분류 : "+this.category);
			System.out.println("가격 : "+this.price+"원");
			if(this.event) {//this.event가 true라면
//			if(!this.event) {//this.event가 false라면
				int discount = this.price - 500;//임시변수(메소드 종료시 사라짐 : 로컬,지역변수)
				System.out.println("→ 할인가격 : "+discount+"원");
			}
			//System.out.println("행사여부 : "+this.event);
		}
	}

