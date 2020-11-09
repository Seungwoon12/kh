package oop.inherit7;

public class Test01 {
	public static void main(String[] args) {
		//각각의 휴대폰들의 인스턴스를 생성하여 기능 사용
		ZFlip a = new ZFlip();
		V60 b = new V60();
		IPhone11 c = new IPhone11();
		
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