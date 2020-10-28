package api.collection4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test02 {
	public static void main(String[] args) {
		//회원가입 프로그램
		// - 데이터는 id와 password 두 개가 있다
		// - key의 역할을 id가 수행한다.
		// - value의 역할을 password가 수행한다.
		
		Map<String, String> db = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			//1명
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String password = sc.next();
			
			if(!db.containsKey(id)) {//db에 아이디가 없다면 = containsKey()사용
				db.put(id, password);
				System.out.println("가입 완료");
			}
			else {
				System.out.println("아이디가 이미 사용중입니다");
			}
//			System.out.println(db);//확인용
//			System.out.println(db.size());//확인용
		}
		
	}
}