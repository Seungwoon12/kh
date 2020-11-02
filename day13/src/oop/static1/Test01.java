package oop.static1;

public class Test01 {
	public static void main(String[] args) {
		//목표 : 10 + 20을 Calculator로 계산
		Calculator a = new Calculator(10L, 20L);
		long total = a.getTotal();
		System.out.println("합계 = "+total);
		
		//목표 : 20 + 30을 Calculator로 계산
		Calculator b = new Calculator(20L, 30L);
		total = b.getTotal();
		System.out.println("합계 = "+total);
		
		//문제점 : 간단한 작업을 매번 객체를 만들어서 수행해야 한다
		//해결책 : 
		// - 객체를 만들지 않고도 계산할 수 있는 방법을 찾는다(o)
		// - 하나의 객체만 만들어두고 계속 계산하도록 한다
	}
}
