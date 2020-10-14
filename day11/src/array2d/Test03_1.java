package array2d;

public class Test03_1 {
	public static void main(String[] args) {
		//2차원 배열의 생성과 출력
		
		int row = 5;
		int col = 5;
		int[][] data = new int[row][col]; 
			
		
			
		int num = 1;	
			
		for(int k=0; k<row; k++) {
			for(int i=0; i<col; i++) {
				data[k][i] = num++;
				System.out.print(data[k][i]);
	
			}
			
		}
		
				
	}
}
