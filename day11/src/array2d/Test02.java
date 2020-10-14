package array2d;

public class Test02 {
	public static void main(String[] args) {
		int[] a = new int[] {50, 60, 70};
		int[] b = new int[] {65, 75, 85};
		
		int[][] c = new int[2][3];
		c[0] = a;
		c[1] = b;
		
		
		
		for(int k=0; k<=1; k++) {
			
			for(int i=0; i<c[k].length; i++) {
				System.out.println(c[k][i]);
			}
			
		}
		
		
	
	}
}
