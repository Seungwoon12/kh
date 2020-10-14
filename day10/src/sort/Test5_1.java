package sort;

public class Test5_1 {
	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		for(int k=1 ; k<data.length ; k++) {
			for(int i=k ; i>0 ; i--) {
				if(data[i] < data[i-1]) {
					int temp = data[i];
					data[i] = data[i-1];
					data[i-1] = temp;
					
				}
				
			}
			
		}
		
		
		for(int i=0 ; i<data.length ; i++) {
			System.out.println(data[i]);
		}
						
	}
}