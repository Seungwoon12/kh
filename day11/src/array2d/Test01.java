package array2d;

public class Test01 {
	public static void main(String[] args) {
		//2차원 배열의 등장 배경
		// - 1학년 : 50, 60, 70
		// - 2학년 : 65, 75, 85
		// = 변수6개 = 1차원배열 2개 = 2차원배열 1개
		
		int[] a = new int[] {50, 60, 70};//1학년
		int[] b = new int[] {65, 75, 85};//2학년
		
		//문제 : 뭐든지 2번씩 해야함
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		for(int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
