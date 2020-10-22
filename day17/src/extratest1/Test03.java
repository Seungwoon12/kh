package extratest1;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//입력을 사용자가 직접 하도록 처리
		
		Score[] student = new Score[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<student.length; i++) {
			System.out.println("이름을 입력하세용 : ");
			String name = sc.next();
			System.out.println("자바점수를 입력하세요 : ");
			int java = sc.nextInt();
			System.out.println("JSP점수를 입력하세요 : ");
			int jsp = sc.nextInt();
			
			student[i] = new Score(name, java, jsp);
		}
		
		
		
		
		for(int j=0; j<student.length; j++) {
			student[j].print();
		}
		
		
		
		
	}
}