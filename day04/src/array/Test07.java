package array;

public class Test07 {
	public static void main(String[] args) {
		int[] score = new int[] {60,80,75,85,90,95,93,77,62,85};
		int total = 0;
		for(int i=0 ; i<score.length ; i++) {
			total += score[i];
		}
		double avg = (double)total / score.length;

		System.out.println("평균 : "+avg+"점");
		
		//2번
		int student11 = 82;
		int count = 1;
		for(int i=0 ; i<score.length ; i++) {
			if(score[i] > student11) {
				count++;
			}
		}
		
		System.out.println("등수 : "+count+"등");
	}
}
