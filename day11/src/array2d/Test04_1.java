package array2d;

public class Test04_1 {
	public static void main(String[] args) {
		//줄/칸을 정의
		int row = 5;
		int col = 5;
		
		int[][] data = new int[row][col];
		
		//초기화
		//숫자를 기준으로 하여 반복
		int x=0, y=0;
		for(int i=1; i<=25; i++) {
			//System.out.println("("+((i-1)/5)+","+((i-1)%5)+") 위치에 "+i+"를 대입!");
			System.out.println("("+x+","+y+") 위치에 "+i+"를 대입!");
			data[x][y] = i;
			
			y++;//오른쪽으로 이동
			if(y>=5) {//벗어나려고 하면
				//다음줄 첫번째 칸으로 이동시켜라!
				y=0;
				x++;
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