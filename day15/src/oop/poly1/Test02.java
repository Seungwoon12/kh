package oop.poly1;

import java.util.Random;
public class Test02 {
	public static void main(String[] args) {
		//다형성을 적용하지 않은 코드
		//- 랜덤으로 아무 휴대폰이나 하나 만들어서  전화와 문자기능을 사용
		//- Random 도구 사용
		//- ZFlip(7), V60(8), IPhone11(9) = 7부터 3개
		//- 이건 정적바인딩
		
		Random r = new Random();
		int number = r.nextInt(3) +7;
		System.out.println("number : "+number);
		
		if(number == 7) {
			ZFlip phone = new ZFlip();
			phone.call();
			phone.sms();
			
		}
		else if(number == 8) {
			V60 phone = new V60();
			phone.call();
			phone.sms();
		}
		else {
			IPhone11 phone = new IPhone11();
			phone.call();
			phone.sms();
		}
		
	}
}
