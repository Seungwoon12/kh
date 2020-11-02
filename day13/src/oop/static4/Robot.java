package oop.static4;

public class Robot {
	//기능들을 수행할 수 있는 정적(static) 메소드를 배치
	public static double multiple(double a, double b) {
		return a * b;
	}
	public static int multiple(int a, int b) {
		return a * b;
	}
	
	public static int square(int n) {
		//return n * n;//주의 : n^2는 제곱이 아님(XOR연산)
		return multiple(n, n);//multiple(n,n)을 실행시킨 결과를 반환하라
	}
	
	//원의 넓이 : 원주율 * 반지름 * 반지름 = 3.141592... = Math.PI
	public static double circle(double r) {
		//return 3.14 * r * r;
		return Math.PI * r * r;
	}
	public static double circle(int r) {
		//return 3.14 * r * r;
		//return 3.14 * square(r);
		return Math.PI * square(r);
		//return multiple(3.14, square(r));
	}
	
	//삼각형 넓이 : 밑변 * 높이 / 2.0
	public static double triangle(int w, int h) {
		return w * h / 2.0;
		//return multiple(w, h) / 2.0;
	}
	
}
