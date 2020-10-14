package array2d;

public class Test03_1 {
	public static void main(String[] args) {
		//2차원 배열의 생성과 출력
		
		int row = 5;
		int col = 5;
		int[][] data = new int[row][col]; 
			
	
		int k=0, j=0;
		
		
		
		for(int i=1; i<=25; i++) {
			data[k][j] = i;
			j++;
				
			if(j==data[k].length) {
				j=0;
				k++;
			}
		}
		
		for(int x=0; x<row; x++) {
			for(int y=0; y<col; y++) {
				System.out.print(data[x][y]+" ");
			}
			System.out.println();
		}
	
			
		
	}
}
