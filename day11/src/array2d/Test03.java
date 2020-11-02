package array2d;

public class Test03 {
	public static void main(String[] args) {
		//2차원 배열의 생성과 출력
		// = 표와 같은 형태이므로 (줄, 칸) 정보가 같이 나와야 한다
		
		//1. 비어있는 배열을 생성
		//a ---	a[0] ----	[ 0 ][ 0 ][ 0 ]
		//		a[1] ----	[ 0 ][ 0 ][ 0 ]
		int[][] a = new int[2][3];
		a[1][1] = 50;
		System.out.println(a[0/*번줄*/][0/*번칸*/]);
		System.out.println(a[0/*번줄*/][1/*번칸*/]);
		System.out.println(a[0/*번줄*/][2/*번칸*/]);
		System.out.println(a[1/*번줄*/][0/*번칸*/]);
		System.out.println(a[1/*번줄*/][1/*번칸*/]);
		System.out.println(a[1/*번줄*/][2/*번칸*/]);
		
		//2차원 배열의 전체 반복문 샘플 코드
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.println(a[i][j]);
			}
		}
		
		//2. 데이터를 추가하면서 생성
		//b	---	b[0] ----	[ 10 ][ 20 ][ 30 ]
		//		b[1] ----	[ 40 ][ 50 ][ 60 ]
		int[][] b = new int[][] {
			{10, 20, 30},{40, 50, 60}
		};
		
		
		int row = 2;//줄수
		int col = 3;//칸수
		int[][] c = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.println(c[i][j]);
			}
		}
	}
}