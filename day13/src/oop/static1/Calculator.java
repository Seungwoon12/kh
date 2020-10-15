package oop.static1;

public class Calculator {
	//멤버 변수(인스턴스 변수)
	private long a;
	private long b;
	
	public Calculator(long a, long b) {
		this.a = a;
		this.b = b;
	}
	
	//합계 getter
	public long getTotal() {
		return this.a + this.b;
	}
}
