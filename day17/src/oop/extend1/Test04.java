package oop.extend1;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//입력을 사용자가 직접 하도록 처리
		Student[] stu = new Student[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<stu.length; i++) {
			System.out.println("이름 입력");
			String name = sc.next();
			System.out.println("자바점수 입력");
			int java = sc.nextInt();
			System.out.println("JSP점수 입력");
			int jsp = sc.nextInt();
			
			stu[i] = new Student(name, java, jsp);
		}
		
		for(int i=0; i < stu.length; i++) {
			stu[i].print();
		}
	}
}