package oop.static1;

public class Test01 {
	public static void main(String[] args) {
		Calculator a = new Calculator(10L, 20L);
		long total = a.getTotal();
		System.out.println("합계 : "+total);
		
		Calculator b = new Calculator(20L, 30L);
		total = b.getTotal();
		System.out.println("합계 : "+total);
	}
}

