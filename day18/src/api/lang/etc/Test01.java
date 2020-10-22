package api.lang.etc;

public class Test01 {
	public static void main(String[] args) {
				//java.lang.Math 클래스
				//- 수학 계산을 수행하는 클래스
				//- 생성자가 없는 클래스?!
				//- 인스턴스 생성이 불가능(편하게 쓰게 static으로 처리 or 생성을 제한(대행)하는 경우)
				
//				Math a = new Math();
				
				//abs() : 절대값(차이를 계산)
				int a = 50;
				int b = 70;
				System.out.println(Math.abs(a - b));
				System.out.println(Math.abs(b - a));
				
				//round() : 반올림
				double c = 1.5;
				System.out.println(Math.round(c));
				
				//random() : 무작위 실수(0이상 1미만) ----> Random 클래스가 더 잘함
				double d = Math.random();
				System.out.println(d);
				
				//pow() : 거듭제곱
				System.out.println(2^10);//xor
				System.out.println(Math.pow(2, 10));
				
				//PI : 원주율
				System.out.println(Math.PI);
				
	}
}
