package array;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[6];
		for(int i=0 ; i<a.length ; i++) {
			System.out.print("로또번호(1~45) : ");
			a[i] = sc.nextInt();
			
		}
		for(int i=0 ; i<a.length ; i++) {
			System.out.print(a[i]+" ");
		}
			
	
		
				
		
		
	}
}
