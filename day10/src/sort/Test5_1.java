package sort;
//import java.lang.*;
public class Test5_1 {
	public static void main(String[] args) {
		//데이터 준비
		int[] data = new int[] {20, 5, 15, 10, 50, 40, 30, 60, 70};
		//삽입정렬
		

		
		for(int k=1; k<data.length; k++) {
			int m=k;
			int backup = data[k];
		
			for(int i=k-1; i>=0; i--) {
				if(backup < data[i]) {
					data[i+1] = data[i];
					m--;	
				}
				else {
					break;
				}
			 }
			
			data[m] = backup;
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
		
		
	
		
		
	