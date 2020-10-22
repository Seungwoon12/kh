package api.lang.string;

import java.util.Scanner;
public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("닉네임을 입력하세요 : ");
//		String name = sc.next();
		
	
//		while(true){
//			System.out.println("닉네임을 입력하세요 : ");
//			String name = sc.next();
//			if(name.length() >= 2 && name.length() <= 6) {
//				if(!name.contains("운영자")) {
//					System.out.println("닉네임 생성 완료!");
//					break;
//				}
//				else if(name.contains("운영자")){
//					System.out.println("다시 생성해주세요!");	
//				}
//			}
//				
//			else {
//				System.out.println("다시 생성해주세요!");
//			}
			
			while(true) {
				System.out.println("닉네임을 입력하세요");
				String nickname = sc.next();
				
				boolean lengthOk = nickname.length() >= 2 && nickname.length() <= 6;
				boolean adminOk = !nickname.contains("운영자");
				if(lengthOk && adminOk) {
					System.out.println("설정 완료!");
					break;
				}
				else {
					System.out.println("잘못된 닉네임입니다");
				}
			
		}
		
		
	}
}
