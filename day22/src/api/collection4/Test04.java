package api.collection4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//저장소
		Map<String, Integer> vote = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("래퍼 입력 : ");
			String name = sc.next();
			if(name.equals("그만")) {
				break;
			}
			
			if(!vote.containsKey(name)) {
				vote.put(name, 0);
			}
			int count = vote.get(name);
			vote.put(name, count + 1);
			System.out.println("["+name+"]을(를) 입력하셨습니다. 현재 득표수 : " + vote.get(name));
		}
		
		System.out.println("프로그램을 종료합니다");
		sc.close();
	}
}