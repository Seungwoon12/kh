package oop.final1;

public class Test01 {
	public static void main(String[] args) {
		//final 키워드 : 불변(마지막)
		
		//기본적으로 변수는 언제든지 변경(덮어쓰기)이 가능하다.
		int a = 10;
		a = 20;
		a = 30;
		a = 40;
		System.out.println("a = " + a);
		
		//변수 앞에 final이 붙으면 해당 변수는 수정이 불가하며 읽기 전용이 된다.
		//- final을 메소드나 클래스에 붙일 수도 있는데 이 부분은 "상속" 단원에서 다룬다.
		final double pi = 3.14;
		//pi = 1.5;
		System.out.println("pi = " + pi);
	}
}