package sort;

public class Test04 {
	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40,};
		
		for(int k=data.length-1 ; k>0 ; k--) {
			
			for(int i=0 ; i<k ; i++ ) {
				if(data[i] > data[i+1]) {
					int temp = data[i+1];
					data[i+1] = data[i];
					data[i] = temp;
				}
			}
		}
		
		for(int i=0 ; i<data.length ; i++) {
			System.out.println(data[i]);
		}
	
			
		
		
			
		}
		
	}

			

