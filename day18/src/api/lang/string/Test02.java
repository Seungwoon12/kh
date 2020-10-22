package api.lang.string;

import java.util.Scanner;
public class Test02 {
	public static void main(String[] args) {
		//로그인 프로그램
		
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
