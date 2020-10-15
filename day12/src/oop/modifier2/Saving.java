package oop.modifier2;

public class Saving {
	private String name;
	private float basic;
	private float special;
	private int money;
	private int period;
	
	void setName(String name) {
		this.name = name;
	}	
	void setBasic(float basic) {
		if(basic <= 0.0) {
			return;
		}
		this.basic = basic;
	}
	void setSpecial(float special) {
		if(special < 0.0) {
			return;
		}
		this.special = special;
	}
	void setMoney(int money) {
		switch(money) {
		case 100: case 200: case 500: case 1000:
		this.money = money;
		}
		return;
	}
	void setPeriod(int period) {
		if(period % 10 != 0) {
			return;
		}
		this.period = period;
	}
	
	void info(String name, float basic, float special, int money, int period) {
		this.setName(name);
		this.setBasic(basic);
		this.setSpecial(special);
		this.setMoney(money);
		this.setPeriod(period);
	}
	
	
	void print() {
		System.out.println("상품명 : "+this.name);
		System.out.println("기본이율 : "+this.basic+"%");
		System.out.println("우대이율 : "+this.special+"%");
		System.out.println("월 납입액 : "+this.money+"만원");
		System.out.println("기간 : "+this.period+"개월");
	}
	
}
