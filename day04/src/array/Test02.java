package array;

public class Test02 {
	public static void main(String[] args) {
//		100, 200, 300을 배열을 만들어서 저장 후 출력
//		= 정수 3개 = int 변수 3개 = int 배열 1개
//		= new는 만들면서 공간을 초기값으로 설정
		
//		a ---- [ 0 ][ 0 ][ 0 ]
		int[] a = new int[3];
//		int a[] = new int[3];
		
		a[0] = 100;
		a[1] = 200;
		a[2] = 300;

		System.out.println(a.length);
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		
//		1.5, 2.5, 3.5를 배열을 만들어서 저장 후 출력
//		= 실수 3개 = double 변수 3개 = double 배열 1개
		
//		b ---- [ 0.0 ][ 0.0 ][ 0.0 ]
		double[] b = new double[3];
//		double b[] = new double[3];
		b[0] = 1.5;
		b[1] = 2.5;
		b[2] = 3.5;

//		System.out.println(b.length);
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
//		System.out.println(b[3]);
		
		
	}
}