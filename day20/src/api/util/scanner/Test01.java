package api.util.scanner;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		String str = "떳다떳다 비행기 날아라 날아라 떳다떳다 비행기 우리비행기";
		
		//Scanner를 사용해서 문자열을 읽을 수 있다.
		Scanner sc = new Scanner(str);
		
		//.next() : 공백을 기반으로 문자열을 구분해서 읽어오는 명령
		//.hasNext() : 읽어올 데이터가 있는지를 파악하는 명령
		while(sc.hasNext()) {
			System.out.println(sc.next());
			
		}
		
		//스캐너와 같은 읽기/쓰기 도구들은 반드시 사용한 뒤에 정리를 해야한다
		sc.close();
	}
}