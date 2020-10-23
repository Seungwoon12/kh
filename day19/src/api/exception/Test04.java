  
package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
//		예외 정보 객체(e)를 분석하는 시간
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("사과 개수를 입력하세요");
			int apple = sc.nextInt();
			System.out.println("인원수를 입력하세요");
			int people = sc.nextInt();
			
			System.out.println("한사람당 사과를 "+apple/people+"개씩 먹을 수 있어요");
			System.out.println("사과는 "+apple%people+"개가 남아요");
		}
		catch(Exception e) {
			System.err.println("오류가 발생했어요");
			//System.err.println(e.getMessage());//원인메세지(없으면 null이 나옴)
			//e.printStackTrace();//예외처리를 안한것처럼 기록을 남겨 오류를 분석할 수 있게 해줌(개발 끝나면 삭제)
		}
		
	}
}