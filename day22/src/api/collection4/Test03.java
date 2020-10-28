package api.collection4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//저장소
		Map<String, String> db = new HashMap<>();
		
		//데이터 추가
		db.put("admin", "admin1234");
		db.put("master", "master1234");
		db.put("test", "test1234");
		db.put("user", "user1234");
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("Password : ");
		String password = sc.next();
		sc.close();
		
//		if(로그인 성공이라면) {
//		if(아이디 존재 && 비밀번호 일치) {
		if(db.containsKey(id) && db.get(id).equals(password)) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
	}
}