package oop.constant1;

import java.util.Random;

public class Test01 {
	//말로만 약속만 하지말고 실제로 효과를 발휘하는 약속 변수를 생성(상수)
		//- public으로 공개해서 아무나 접근 가능
		//- static으로 객체 안만들고 편하게 사용
		//- final로 불변값을 만들어서 오해없이 사용
		
		//가독성 증가, 값을 편하게 접근
		public static final int 가위 = 1;
		public static final int 바위 = 2;
		public static final int 보자기 = 3;
		
		public static void main(String[] args) {
			//컴퓨터가 가위바위보를 랜덤으로 내도록 프로그래밍
			// - 랜덤 = 무엇이 나올지 예측하기 어려운 형태(ex:로또,추첨,주사위,...)
			// - Random이라는 이름의 도구로 랜덤값을 추첨
			// - 약속 : 가위(1), 바위(2), 보자기(3) = 1부터 3개(3까지가 아님)
			
			//도구 생성(Random)
			//- 자동 추천을 눌러 import
			//- 컨트롤 + 쉬프트 + O
			//- 직접 작성
			Random r = new Random();
			int com = r.nextInt(3/*개*/) + 1/*부터*/;
			System.out.println("com = "+com);
			
			switch(com) {
			case 가위:
				System.out.println("가위!");
				break;
			case 바위:
				System.out.println("바위!");
				break;
			case 보자기:
				System.out.println("보자기!");
				break;
			}
		}
}
