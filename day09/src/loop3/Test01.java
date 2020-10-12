package loop3;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		//do~while 반복
		// - 다른 반복문과 약간의 차이만 존재
		// - 먼저 1회 실행을 한 뒤에 실행 여부를 결정
		// - 마지막에 세미콜론 ; 을 반드시 작성해야함
		
		//목표 : 사용자에게 국어점수를 입력받는 프로그램 구현
		Scanner sc = new Scanner(System.in);
		
		int score;
		do {
			System.out.println("국어점수 입력");
			score = sc.nextInt();
		}
		while(score < 0 || score > 100);
		//while(!(score >= 0 && score <= 100));
		
		System.out.println("입력된 점수 : "+score);
	}
}