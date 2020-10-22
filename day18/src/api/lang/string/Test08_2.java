package api.lang.string;

import java.util.Scanner;
public class Test08_2 {
//	객체없이 별을 만드는 메소드 구현
	public static String generate(int size) {
		String str = "";
		for(int i=0; i<size; i++) {
			str += "*";
		}
		return str;
	}
	
	public static void main(String[] args) {
//		필터링 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.println("채팅 입력");
		String input = sc.nextLine();
		
		String[] filter = new String[] {"시베리아","조카","신발","십장생","주옥"};
		
		for(int i=0; i < filter.length; i++) {
			input = input.replace(filter[i], generate(filter[i].length()));
		}
		
		System.out.println(input);
	}
		
}

