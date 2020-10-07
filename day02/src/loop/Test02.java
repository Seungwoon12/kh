package loop;
import java.util.Scanner;
public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0 ; i<6 ; i++) {
			System.out.print("로또번호(1~45번) : ");
			int num = sc.nextInt();		
			sum = sum + num;
			
		}
		
		System.out.println(sum);
	}
}
