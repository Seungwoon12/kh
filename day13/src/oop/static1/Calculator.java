package oop.static1;

//더하기만 하는 계산기
public class Calculator {
	//멤버 변수(인스턴스 변수)
	private long a;
	private long b;
	
	//생성자
	public Calculator(long a, long b) {
		this.a = a;
		this.b = b;
	}
	
	//합계 getter
	public long getTotal() {
		return this.a + this.b;
	}
}
