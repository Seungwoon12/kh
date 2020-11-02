package oop.method1;

public class Test01 {
	public static void main(String[] args) {
		//학생(객체,인스턴스) 생성
		Student a = new Student();
		a.info("홍길동", 90);
		a.print();
		
		//a 객체에서 이름만 이소룡으로 변경하여 출력
		//a.name = "이소룡";
		a.info("이소룡", 90);
		a.print();
		
		//a 객체에서 점수를 80점으로 변경하여 출력
		//a.score = 80;
		a.info("이소룡", -80);
		a.print();
	}
}