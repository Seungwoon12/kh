package api.util.scanner;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		String str = "110 75 999 56789";
		
		//str에서 숫자를 읽는다.
		// = 공백으로 구분하여 4개를 읽는다
		// = .next()와 동일한 방식을 사용한다
		// = .nextInt()는 .next()로 읽은 데이터를 정수로 바꿔서 반환하는 명령이다
		
		Scanner sc = new Scanner(str);
		
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(n);
		}
		
		sc.close();
	}
}