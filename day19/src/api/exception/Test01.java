package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Test01 {
	public static void main(String[] args) {
//		Error : 오류(실행이 불가능한 상황)
//		Exception : 예외(실행 후에 문제가 되는 상황)
		
//		주석을 풀면 바로 에러 발생
//		ㅁㄴ애ㅑㅓㄹ매ㅑㄴ얾ㄴ애ㅑㅓㄹㅁㄴㅇ래ㅑㅓ
		
//		예외
		Scanner sc = new Scanner(System.in);
		System.out.println("사과 개수를 입력하세요");
		int apple = sc.nextInt();
		System.out.println("인원수를 입력하세요");
		int people = sc.nextInt();
		
		System.out.println("한사람당 사과를 "+apple/people+"개씩 먹을 수 있어요");
		System.out.println("사과는 "+apple%people+"개가 남아요");
		
//		정리 : 예외는 2가지 종류가 발생한다
//		- java.util.InputMismatchException
//		- java.lang.ArithmeticException
		
//		Q : 해결을 어떻게 할 것인가?
//		A : 예외 처리(try~catch)구문으로 해결!
	}
	
	
	
}
