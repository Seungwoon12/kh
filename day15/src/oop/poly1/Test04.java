package oop.poly1;

import java.util.Random;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//다형성을 적용한 코드
		Scanner sc = new Scanner(System.in);
		System.out.println("[7]ZFlip , [8]V60 , [9]IPhone11 중에서 선택하세요");
		int number = sc.nextInt();
		
		//어짜피 상속도 되어있고, 재정의도 되어 있으니까 그냥 모두 Phone이라고 생각하자!
		// - 뭐든 뽑아서 Phone 변수에 저장하면 되지 않겠는가?
		//Phone phone = ZFlip객체 or V60객체 or IPhone11객체;
		Phone phone;
		if(number == 7) {//ZFlip
			phone = new ZFlip();
		}
		else if(number == 8) {//V60
			phone = new V60();
		}
		else {//IPhone11
			phone = new IPhone11();
		}
		
		System.out.println(phone);//리모컨 출력
		//phone에 뭐가있을지 모르지만 어쨌든 휴대폰 한대는 있다
		//= 휴대폰이라면 반드시 call(), sms(), camera()를 가지고 있을테니까 그냥 부르면 알아서 실행
		phone.call();
		phone.sms();
	}
}
