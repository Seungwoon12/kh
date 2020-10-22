package api.lang.string;

import java.util.Scanner;
public class Test08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		
		System.out.println("채팅 입력");
		String input = sc.nextLine();
		
	
		String[] curse = new String[] {"신발", "조카", "십장생", "주옥", "시베리아"};
		
		for(int i=0; i<curse.length; i++) {
			input = input.replace(curse[i], "***");
		}
		
		System.out.println(input);
		
		
		
		
	
		
	
	
		
		
				
	
	}
}
