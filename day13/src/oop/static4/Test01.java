package oop.static4;

public class Test01 {
	public static void main(String[] args) {
		int a = Robot.multiple(11, 22);
		System.out.println("a = " + a);
		
		int b = Robot.square(5);
		System.out.println("b = " + b);
		
		double c = Robot.circle(7);
		System.out.println("c = " + c);
		
		double d = Robot.triangle(5, 7);
		System.out.println("d = " + d);
		
	}
}
