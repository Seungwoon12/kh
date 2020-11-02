package array2d;

public class Test02 {
	public static void main(String[] args) {
		//2차원 배열의 등장 배경
		// - 1학년 : 50, 60, 70
		// - 2학년 : 65, 75, 85
		// = 변수6개 = 1차원배열 2개 = 2차원배열 1개
		
		int[] a = new int[] {50, 60, 70};//1학년
		int[] b = new int[] {65, 75, 85};//2학년
		
		int[][] c = new int[2][3];
		c[0] = a;
		c[1] = b;
		
		//문제 : 뭐든지 2번씩 해야함
		for(int k=0; k<=1; k++) {
			for(int i=0; i<c[k].length; i++) {
				System.out.println(c[k][i]);
			}
		}
		
	}
}