package oop.poly1;

public class Test01 {
	public static void main(String[] args) {
//		지금 현재까지의 인스턴스 생성 코드는 좌우측 형태가 동일하다 
//		- 정적 생성 방식
//		ZFlip a = new ZFlip();
//		V60 b = new V60();
//		IPhone11 c = new IPhone11();
		
//		- 동적 생성 방식
		Phone a = new ZFlip();
		Phone b = new V60();
		Phone c = new IPhone11();
		
		a.call();
		a.sms();
		a.camera();
		
		b.call();
		b.sms();
		b.camera();
		
		c.call();
		c.sms();
		c.camera();
	}
}