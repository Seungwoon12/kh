package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
//		예외 처리 구문
//		- try : 감시블록
//		- catch : 처리블록
		
		try {//감시블록
			Scanner sc = new Scanner(System.in);
			System.out.println("사과 개수를 입력하세요");
			int apple = sc.nextInt();
			System.out.println("인원수를 입력하세요");
			int people = sc.nextInt();
			
			System.out.println("한사람당 사과를 "+apple/people+"개씩 먹을 수 있어요");
			System.out.println("사과는 "+apple%people+"개가 남아요");
		}
		catch(ArithmeticException e){//ArithmeticException이 발생하면 정보를 e라는 객체로 전달받겠다!
			System.out.println("사람이 0명인게 말이 되냐 임마");
		}
		catch(InputMismatchException e) {
			System.out.println("숫자 입력하라고 마!");
		}
		
//		Q1 : 왜 프로그램은 7줄인데 처리구문이 8줄이야?
//		Q2 : 진짜 예외는 2개밖에 안생겨? 
//		A : 한방에 다 처리하는 방법을 알아보자!
	}
}