package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
//		예외를 통합해서 처리하는 방법
//		- 다형성
//		- 만약 ArithmeticException과 InputMismatchException이 부모클래스가 같다면 통합이 가능하지 않을까?
//		- 업캐스팅(up-casting)
		
		try {//감시블록
			Scanner sc = new Scanner(System.in);
			System.out.println("사과 개수를 입력하세요");
			int apple = sc.nextInt();
			System.out.println("인원수를 입력하세요");
			int people = sc.nextInt();
			
			System.out.println("한사람당 사과를 "+apple/people+"개씩 먹을 수 있어요");
			System.out.println("사과는 "+apple%people+"개가 남아요");
		}
		catch(Exception e) {//통합 처리는 무조건 Exception으로 하면 한방에 다 처리 가능!
			System.err.println("오류 발생!");
		}
		
//		Q : 오류가 합쳐지고 짧아져서 좋긴한데 구분이 안되는데?
//		A : 예외 정보 객체인 e를 분석해보자!
		
	}
}