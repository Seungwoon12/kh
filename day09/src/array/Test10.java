package array;

import java.util.Scanner;
public class Test10 {
	public static void main(String[] args) {
	
		// Test10 1번
//		int[] data = new int[] {10,20,30,40,50};
//		for(int i=1; i<data.length ; i++) {
//			int temp = data[i];
//			data[i] = data[0];
//			data[0] = temp;
//		}
//		for(int i=0 ; i<data.length ; i++) {
//			System.out.println(data[i]);
//		}		
//	}
//}



		// Test10 2번
		int[] data = new int[] {10,20,30,40,50};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("몇칸 이동시킬지 입력하시오! : ");
		int jump = sc.nextInt();
		for(int x=0 ; x<jump ; x++) {
			for(int i=1 ; i<data.length ; i++) {
				int temp = data[i];
				data[i] = data[0];
				data[0] = temp;
					
			}
		}
				
		for(int i=0 ; i<data.length ; i++) {
			System.out.println(data[i]);
		}
	}
}

	

		