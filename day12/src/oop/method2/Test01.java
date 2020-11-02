package oop.method2;

public class Test01 {
	public static void main(String[] args) {
		Student a = new Student();
		
		//a.name = "홍길동";
		a.setName("홍길동");
		//a.score = -80;
		a.setScore(80);
		
		a.print();
	}
}
