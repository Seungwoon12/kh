package array;

public class Test06 {
	public static void main(String[] args) {
		int[] num = new int[] {3, 5, 4, 1, 4};
		int count = 0;
		for(int i=0 ; i<num.length ; i++) {
			if(num[i]%2 == 0)
				count++;
			
		}
		System.out.println("짝수 개수 : "+count);
		
		//2번
		
	int total = 0;
	
	for(int i=0 ; i<num.length ; i++) {
		total += num[i];
	}
	
	System.out.println("합계 : "+total);
	
	
	//3번
	
	double avg = (double)total / num.length;
	System.out.println(avg);
		
	}
}
