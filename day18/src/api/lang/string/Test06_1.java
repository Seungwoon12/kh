package api.lang.string;

import java.util.Scanner;
public class Test06_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		
		String given = "바나나";
		System.out.println(given+" 쿵쿵따!");
					
		while(true) {
			String input = sc.next();
			
			String start = input.substring(0, 1);
			String end = given.substring(given.length()-1);
			
			boolean connect = start.equals(end);
			boolean three = input.length() == 3;
			
			if(!(three && connect)) {
				System.out.println("틀렸습니다. 게임을 종료시킵니다.");
				break;
			}
			
			System.out.println(input+" 쿵쿵따!");
			
			given = input;
		}
		
		

	
		
				
				
//				이발소		소방서
//				소방서		서수길
//				서수길		무수리
//		
		
	}
}
