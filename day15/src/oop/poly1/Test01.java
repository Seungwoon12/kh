package oop.poly1;

public class Test01 {
	public static void main(String[] args) {
		//지금 현재까지의 인스턴스 생성 코드는 좌우측 형태가 동일하다.
		//- 정적 생성 방식
		ZFlip z = new ZFlip();
		z.call();
		z.sms();
		z.camera();
		
		V60 v = new V60();
		v.call();
		v.sms();
		v.camera();
		
		IPhone11 i = new IPhone11();
		i.call();
		i.sms();
		i.camera();
	}
}
