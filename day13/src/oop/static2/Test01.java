package oop.static2;

public class Test01 {
	public static void main(String[] args) {
		//이전과 다르게 하나의 객체로 연속해서 계산이 가능
		//- 더하기는 어짜피 아주 많이 사용하는 기능인데
		//- 꼭 객체를 만들어야만 쓸 수 있을까?
		Calculator a = new Calculator();
		long total = a.plus(10L, 20L);
		System.out.println("합계 = "+total);
		
		total = a.plus(20L, 30L);
		System.out.println("합계 = "+total);
	}
}
