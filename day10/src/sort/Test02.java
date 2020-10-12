package sort;

public class Test02 {
	public static void main(String[] args) {
		int[] score = new int[] {50, 80, 95, 60, 90};
		
		int maxValue = score[0];
		int maxIndex = 0;
		
		for(int i=1 ; i<score.length ; i++) {
			if(maxValue < score[i]) {
				maxValue = score[i];
				maxIndex = i;
			}
		}
		
		
		
		System.out.println("가장 높은 점수 : "+maxValue);
		System.out.println("가장 높은 점수의 위치 : "+maxIndex);
	}
}
