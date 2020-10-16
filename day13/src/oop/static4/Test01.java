package oop.static4;

public class Test01 {
	public static void main(String[] args) {
		long multiply = Robot.multiply(11L, 22L);
		System.out.println("곱하기 : "+multiply);
		
		long square = Robot.square(5L);
		System.out.println("제곱 : "+square);
		
		double circleWidth = Robot.circleWidth(7);
		System.out.println("원의 넓이 : "+circleWidth);
		
		
		double triangleWidth = Robot.triangleWidth(5, 7);
		System.out.println("삼각형의 넓이 : "+triangleWidth);	
	}	
}
