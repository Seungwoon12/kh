package sort;

public class Test3_1 {
	public static void main(String[] args) {
		
		//언제든지 바뀔 수 있는 데이터 준비
		int[] data = new int[] {30, 50, 20, 10, 40,};
	
		
		
		for(int k=0 ; k<data.length-1 ; k++) {
			
			int minIndex = k;
			
			for(int i=k+1 ; i<data.length ; i++) {
				if(data[minIndex] > data[i]) {
					minIndex = i;
				}		
			}
			
			int temp = data[minIndex];
			data[minIndex] = data[k];
			data[k] = temp;
		}
		
		
		
		for(int i=0 ; i<data.length ; i++) {
			System.out.println(data[i]);
		}
		
	}
}