package oop.static2;

public class Test01 {
	public static void main(String[] args) {
		Calculator a = new Calculator();
		
		long total = a.plus(10L, 20L);
		System.out.println("합계 : "+total);
		
		total = a.plus(20L, 30L);
		System.out.println("합계 : "+total);
	}
}
