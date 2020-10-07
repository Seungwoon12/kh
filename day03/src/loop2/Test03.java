package loop2;
import java.util.Scanner;
public class Test03 {
	public static void main(String[] args) {
		//목표 : 사용자가 0을 입력할 때까지 숫자를 입력받는 프로그램
		// - 사용자는 몇번만에 0을 입력할까??
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("숫자 입력(0이면 종료) : ");
			int user = sc.nextInt();
			if(user == 0) {
				break;
			}
		}
		System.out.println("프로그램 종료!");
	}
}	
