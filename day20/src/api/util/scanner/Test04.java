package api.util.scanner;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//Scanner를 이용하면 통로(stream)를 읽을 수 있다.
		// - 표준 입력 통로(System.in)을 읽을 수 있다
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력");
		System.out.println(sc.next());
		
		
		sc.close();
	}
}