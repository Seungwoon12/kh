package array;

public class Test09 {
	public static void main(String[] args) {
	
		int[] data = new int[] {10, 20, 30, 40, 50,};
	
			for(int i=0 ; i<data.length/2 ; i++) {
				int temp = data[i];
				data[i] = data[data.length-1-i];
				data[data.length-1-i] = temp;
			}
			
			for(int i=0 ; i<data.length ; i++) {
				System.out.println(data[i]);
			}
		}
	}
	


