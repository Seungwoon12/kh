package oop.constructor1;

public class Test01 {
	public static void main(String[] args) {
		//학생 객체를 생성
		//Student s1 = new Student();//생성 불가능
		Student s1 = new Student("홍길동", 80);
		Student s2 = new Student("피카츄", 50);
		
		s1.print();
		s2.print();
	}
}
