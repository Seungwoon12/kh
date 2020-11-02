package oop.modifier2;

public class Account {
	//멤버 변수(인스턴스 변수) - private으로 잠금 처리(영원히)
	private String name;
	private float base;
	private float plus;
	private int monthly;
	private int period;
	
	//멤버 메소드(인스턴스 메소드) - this를 사용할 수 있음
	//- setter 메소드 , info , print , 그 외...
	void setName(String name) {
		this.name = name;
	}
	void setBase(float base) {
		if(base <= 0) {
			return;
		}
		this.base = base;
	}
	void setPlus(float plus) {
		if(plus < 0) {
			return;
		}
		this.plus = plus;
	}
	void setMonthly(int monthly) {
		switch(monthly) {
		case 1000000: case 2000000: case 5000000: case 10000000:
			this.monthly = monthly;
		}
	}
	void setPeriod(int period) {
		if(period % 10 != 0) {
			return;
		}
		this.period = period;
	}
	
	void info(String name, float base, float plus, int monthly, int period) {
		this.setName(name);
		this.setBase(base);
		this.setPlus(plus);
		this.setMonthly(monthly);
		this.setPeriod(period);
	}
	
	void print() {
		System.out.println(this.name);
		System.out.println(this.base);
		System.out.println(this.plus);
		System.out.println(this.monthly);
		System.out.println(this.period);
	}
	
	//+생성자(constructor)
	//+중첩클래스(nested class)
}