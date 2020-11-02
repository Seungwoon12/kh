package array2d;

public class Test04 {
	public static void main(String[] args) {
		//줄/칸을 정의
		int row = 5;
		int col = 5;
		
		int[][] data = new int[row][col];
		
		//초기화
		int number = 1;
		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				System.out.println("i="+i+",j="+j);
				//data[i][j] = 5 * i + j + 1;
				data[i][j] = number++;
			}
		}
		
		//출력
		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				System.out.println("i="+i+",j="+j+",data="+data[i][j]);
			}
		}
	}
}
