package loop2;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		
		while(true) {
			System.out.print("짝수 입력(홀수면 종료)! : ");
			int num = sc.nextInt();
			if(num%2 == 1) {
				break;
			}
			else {
				total += num;
				}
			
			}
		System.out.println("숫자 합계 : "+total);
	}
		
}

