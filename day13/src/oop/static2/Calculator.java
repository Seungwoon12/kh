package oop.static2;

public class Calculator {
	//기존의 멤버 메소드의 문제점 : 
	// - 멤버 필드와 연계한다
	//해결책 : 
	// - 멤버 필드를 없에고 매개변수로 데이터를 즉시 받아서 반환하도록 구성
	public long plus(long a, long b) {
		return a + b;
	}
	
	//클래스에 생성자가 없으면 비어있는 생성자 1개가 기본 제공됨
	//public Calculator() {}
}