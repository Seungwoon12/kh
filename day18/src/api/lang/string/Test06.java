package api.lang.string;

import java.util.Scanner;
public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		//원시형은 ==로 비교해야함 ex)char로 풀 경우 equals가 아니라 ==로 비교
 		
		System.out.println("단어를 입력하세요!"); //1번
		String word = sc.next();
		System.out.println("단어를 입력하세요!");
		String word2 = sc.next();
	
		
		if(word.substring(word.length()-1).equals(word2.substring(0, 1))) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
		

		
		
		
		
		
	}
}
