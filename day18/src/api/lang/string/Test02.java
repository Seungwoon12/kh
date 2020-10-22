package api.lang.string;

import java.util.Scanner;
public class Test02 {
	public static void main(String[] args) {
		//로그인 프로그램
		//contentEquals는  String이 아니라 다른 클래스와 비교가 가능
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String pw = sc.next();
		
		if(id.equals("khacademy") && pw.equals("master")) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
	}
}
