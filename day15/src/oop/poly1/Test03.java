package oop.poly1;

import java.util.Random;
public class Test03 {
	public static void main(String[] args) {
		//다형성을 적용하지 않은 코드
		//- 랜덤으로 아무 휴대폰이나 하나 만들어서  전화와 문자기능을 사용
		//- Random 도구 사용
		//- ZFlip(7), V60(8), IPhone11(9) = 7부터 3개
		//- 다형성을 적용한 코드(동적바인딩)
		
		Random r = new Random();
		int number = r.nextInt(3) +7;
		System.out.println("number : "+number);
		
		//어차피 상속도 되어있고, 재정의도 되어 있으니까  그냥 모두  Phone이라고 생각하자!
		//- 뭐든 뽑아서 Phone 변수에 저장하면 되지  않겠는가?
		Phone phone;
		if(number == 7) {
			phone = new ZFlip();
		}
		else if(number == 8) {
			phone = new V60();
		}
		else {
			phone = new IPhone11();
		}
		
		System.out.println(phone); //리모컨 출력
		//phone에 뭐가있을지 모르지만 어쨌든 휴대폰 한대는 있다
		//= 휴대폰이라면 반드시 call(), sms(), camera()를 가지고 있을테니까 그냥 부르면 알아서 실행
		
		phone.call();
		phone.sms();
	}
}
