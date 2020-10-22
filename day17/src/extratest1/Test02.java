package extratest1;

public class Test02 {
	public static void main(String[] args) {
		
		//입력을 반복문으로 처리
		// - 입력을 반복문으로 처리하려면 이름, 점수에 대한 배열이 따로 있어야 한다. 
		
		String[] namelist = new String[] {"이오리", "김갑환", "최번개"};
		int[] javalist = new int[] {80, 70, 100};
		int[] jsplist = new int[] {70, 90, 45};
		
		
		
		Score[] student = new Score[3];
		
		
		for(int i=0; i<student.length; i++) {
			student[i] = new Score(namelist[i], javalist[i], jsplist[i]);
		
			
		}
		
		for(int j=0; j<student.length; j++) {
			student[j].print();
		}
		
		
		
		
	}
}